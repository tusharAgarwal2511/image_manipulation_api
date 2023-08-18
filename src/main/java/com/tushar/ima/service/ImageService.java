package com.tushar.ima.service;

import com.tushar.ima.exceptions.ValueOutOfRangeException;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.IOException;

@Service
public interface ImageService
{


	BufferedImage test(BufferedImage image) throws IOException;

	BufferedImage greyscale(BufferedImage image) throws IOException;

	BufferedImage saturate(BufferedImage image) throws IOException;

	BufferedImage desaturate(BufferedImage image) throws IOException;

	BufferedImage retroNewspaper(BufferedImage image) throws IOException;

	BufferedImage sapphire(BufferedImage image) throws IOException;

	BufferedImage ruby(BufferedImage image) throws IOException;

	BufferedImage emerald(BufferedImage image) throws IOException;

	BufferedImage desert(BufferedImage image) throws IOException;

	BufferedImage arctic(BufferedImage image) throws IOException;

	BufferedImage blur(BufferedImage image, int blurStrength) throws IOException;

	BufferedImage brighten(BufferedImage image, double brightness) throws IOException, ValueOutOfRangeException;

	BufferedImage darken(BufferedImage image, double darkness) throws IOException, ValueOutOfRangeException;

}
