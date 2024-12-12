package com.application.utils;

import org.geotools.coverage.CoverageFactoryFinder;
import org.geotools.coverage.grid.GridCoordinates2D;
import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.coverage.grid.GridCoverageFactory;
import org.geotools.coverage.grid.GridEnvelope2D;
import org.geotools.coverage.grid.GridGeometry2D;
import org.geotools.coverage.grid.io.AbstractGridFormat;
import org.geotools.coverage.grid.io.OverviewPolicy;
import org.geotools.coverage.processing.CoverageProcessor;
import org.geotools.coverage.processing.Operations;
import org.geotools.gce.geotiff.GeoTiffFormat;
import org.geotools.gce.geotiff.GeoTiffReader;
import org.geotools.gce.geotiff.GeoTiffWriter;
import org.geotools.geometry.Envelope2D;
import org.geotools.geometry.GeneralEnvelope;
import org.geotools.geometry.jts.ReferencedEnvelope;
import org.geotools.metadata.iso.extent.GeographicBoundingBoxImpl;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.geotools.referencing.operation.transform.AffineTransform2D;
import org.geotools.util.factory.Hints;
//import org.jgrasstools.gears.libs.modules.JGTProcessingRegion;

import org.locationtech.jts.geom.Envelope;
import org.opengis.coverage.grid.GridCoverageWriter;
import org.opengis.coverage.grid.GridGeometry;
import org.opengis.parameter.GeneralParameterValue;
import org.opengis.parameter.ParameterValue;
import org.opengis.parameter.ParameterValueGroup;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.datum.PixelInCell;
import org.opengis.referencing.operation.MathTransform;

import javax.media.jai.Interpolation;
import java.awt.geom.AffineTransform;
import java.io.File;

public class TileUtil {
    public static void coverageCropTest(){
        try{
            File file = new File("D:/merge_res_4_4326.tif");

            Hints hint = new Hints();
            hint.put(Hints.DEFAULT_COORDINATE_REFERENCE_SYSTEM, DefaultGeographicCRS.WGS84);
            hint.put(Hints.FORCE_LONGITUDE_FIRST_AXIS_ORDER, Boolean.TRUE);

            GeoTiffReader reader = new GeoTiffReader(file, hint);
            GridCoverage2D coverage = reader.read(null);

            System.out.println(coverage.getEnvelope().toString());
            System.exit(0);
            //ReferencedEnvelope envelopeInitial = new ReferencedEnvelope(coverage.getEnvelope(), DefaultGeographicCRS.WGS84);
            CoverageProcessor processor = CoverageProcessor.getInstance();

            final ParameterValueGroup param = processor.getOperation("CoverageCrop").getParameters();

// 137.915315044103 -36.51629558851893 154.64770004642423 -40.081875882617666
            /*double minLong = 137.915315044103;
            double maxLong = 154.64770004642423;
            double minLat = -40.081875882617666;
            double maxLat = -36.51629558851893;*/
            //117.5117,31.5016,117.616,31.5938
            double minLong = 117.5117;
            double maxLong = 117.616;
            double minLat = 31.5016;
            double maxLat = 31.5938;

            //final GeneralEnvelope crop = new GeneralEnvelope(new GeographicBoundingBoxImpl(minLong, maxLong,
            //        minLat, maxLat));

            ReferencedEnvelope envelope = new ReferencedEnvelope(new Envelope(minLong, maxLong,
                    minLat, maxLat), DefaultGeographicCRS.WGS84);

            param.parameter("Source").setValue(coverage);
            param.parameter("Envelope").setValue(envelope);

            GridCoverage2D cropped = (GridCoverage2D) processor.doOperation(param);

            GridCoverageFactory gcf = new GridCoverageFactory();
            GridCoverage2D gc = gcf.create("name", cropped.getRenderedImage(), cropped.getEnvelope());
            String url = "D:/merge_res_4_4326_geotiff_crop_2.tif";
            File outputFile = new File(url);
            GeoTiffWriter writer = new GeoTiffWriter(outputFile);
            writer.write(gc, null);
            writer.dispose();
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public static void resampleResolution(){
        try{
            File file = new File("D:/merge_res_4_4326.tif");

            Hints hint = new Hints();
            hint.put(Hints.DEFAULT_COORDINATE_REFERENCE_SYSTEM, DefaultGeographicCRS.WGS84);
            hint.put(Hints.FORCE_LONGITUDE_FIRST_AXIS_ORDER, Boolean.TRUE);

            GeoTiffReader reader = new GeoTiffReader(file, hint);
            //GeneralEnvelope envelopeInitial =reader.getOriginalEnvelope();
            GridCoverage2D coverage = reader.read(null);
            CoverageProcessor processor = CoverageProcessor.getInstance();
            double minLong = 117.289324275;
            double maxLong = 117.836208324;
            double minLat = 31.429369313;
            double maxLat = 31.719307776;
            ReferencedEnvelope envelope = new ReferencedEnvelope(new Envelope(minLong, maxLong,
                    minLat, maxLat), DefaultGeographicCRS.WGS84);




            GridCoverageFactory gcf = new GridCoverageFactory();
            MathTransform gridToCRS = reader.getOriginalGridToWorld(PixelInCell.CELL_CENTER);


            System.out.println("gridToCRS:"+gridToCRS);
    //300.019 -300.019
            AffineTransform tx;
            //tx = new AffineTransform(0.00054 ,-0.00054, 0,31.71919290339184 ,117.28945910834541 , 0);
            tx = new AffineTransform(0.00054, 0,0 ,-0.00054 ,0 , 0);
            gridToCRS = new AffineTransform2D(tx);
            System.out.println("gridToCRS:"+gridToCRS);

            final GeneralEnvelope intersectionEnvelope;
            final GeneralEnvelope originalEnvelope = reader.getOriginalEnvelope();
            final GeneralEnvelope requestedEnvelope;
            final CoordinateReferenceSystem nativeCRS =
                    originalEnvelope.getCoordinateReferenceSystem();
            final GeneralEnvelope requestedEnvelopeInNativeCRS;
            requestedEnvelopeInNativeCRS = reader.getOriginalEnvelope();
            requestedEnvelope = requestedEnvelopeInNativeCRS;
            final GeneralEnvelope intersectionEnvelopeInSourceCRS =
                    new GeneralEnvelope(requestedEnvelopeInNativeCRS);
            intersectionEnvelopeInSourceCRS.intersect(originalEnvelope);
            intersectionEnvelope = intersectionEnvelopeInSourceCRS;
            System.out.println("intersectionEnvelope:"+intersectionEnvelope);
            final CoordinateReferenceSystem targetCRS;
            targetCRS = reader.getOriginalEnvelope().getCoordinateReferenceSystem();
            Interpolation interpolation = Interpolation.getInstance(Interpolation.INTERP_NEAREST);
            final GridGeometry2D destinationGridGeometry =
                    new GridGeometry2D(
                            PixelInCell.CELL_CENTER, gridToCRS, intersectionEnvelope, hint);
            ParameterValueGroup param = processor.getOperation("Resample").getParameters();

            System.out.println("destinationGridGeometry:"+destinationGridGeometry);
            param.parameter("Source").setValue(coverage);
            param.parameter("CoordinateReferenceSystem").setValue(targetCRS);
            param.parameter("GridGeometry").setValue(destinationGridGeometry);
            param.parameter("InterpolationType").setValue(interpolation);
            System.out.println("param:"+param);
            GridGeometry2D targetGG =
                    GridGeometry2D.wrap((GridGeometry) param.parameter("GridGeometry").getValue());
            MathTransform temp = GridGeometry2D.wrap((GridGeometry) param.parameter("GridGeometry").getValue()).getCRSToGrid2D();
            System.out.println("targetGG:"+targetGG);
            System.out.println("temp:"+temp);
            GridCoverage2D resampled = (GridCoverage2D) processor.doOperation(param,hint);
            GridCoverage2D gc = gcf.create("name", resampled.getRenderedImage(), resampled.getEnvelope());
            String url = "D:/merge_res_4_4326_geotiff_resample_1.tif";
            File outputFile = new File(url);
            GeoTiffWriter writer = new GeoTiffWriter(outputFile);
            writer.write(gc, null);
            writer.dispose();
        }catch (Exception e){
            e.printStackTrace();
        }


    }


    public static void main(String[] args)  {
       //coverageCropTest();
        resampleResolution();
    }
}
