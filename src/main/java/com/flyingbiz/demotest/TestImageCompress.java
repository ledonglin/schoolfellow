package com.flyingbiz.demotest;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class TestImageCompress {

	
	public static void main(String args[]) throws IOException {
		//watermark(位置，水印图，透明度)
		Thumbnails.of("C:/20131227172325812.png")
			.size(1280,1024)
			.watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File("C:/88d625c9e9bb6fcced55b8dbd94c641c.jpg")),0.5f)
			.outputQuality(0.8f)
			.toFile("c:/a380_watermark_bottom_right.jpg");
		
	}
	
}
