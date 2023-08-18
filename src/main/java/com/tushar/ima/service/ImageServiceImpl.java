package com.tushar.ima.service;

import com.tushar.ima.exceptions.ValueOutOfRangeException;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService
{


	@Override
	public BufferedImage test(BufferedImage image) throws IOException
	{
		return image;
	}

	@Override
	public BufferedImage greyscale(BufferedImage image) throws IOException
	{
//		BufferedImage tempImage = image;

		BufferedImage editedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		int           rgb         = 0; // rbg - (red , green and blue) value
		int           r           = 0; // r - red value
		int           g           = 0; // g - green value
		int           b           = 0; // b - blue value

//		boolean f = true;

		for (int y = 0; y < image.getHeight(); y++)
		{
			for (int x = 0; x < image.getWidth(); x++)
			{

//				if (x < image.getWidth() / 2)
//				{
//					editedImage.setRGB(x, y, image.getRGB(x, y));
//					continue;
//				}
				rgb = (int) image.getRGB(x, y);
				r   = ((rgb >> 16) & 0xFF);
				g   = ((rgb >> 8) & 0xFF);
				b   = (rgb & 0xFF);
				rgb = (int) ((r + g + b) / 3);
				rgb = (255 << 24) | (rgb << 16) | (rgb << 8) | rgb;
				editedImage.setRGB(x, y, rgb);
			}
		}

		return editedImage;


	}

	@Override
	public BufferedImage saturate(BufferedImage image) throws IOException
	{
		BufferedImage editedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

		int r = 0; // r - red value
		int g = 0; // g - green value
		int b = 0; // b - blue value

		boolean f = true;

		for (int y = 0; y < image.getHeight(); y++)
		{
			for (int x = 0; x < image.getWidth(); x++)
			{
				Color pixelColor = new Color(image.getRGB(x, y));

				float[] hsb = Color.RGBtoHSB(
					pixelColor.getRed(),
					pixelColor.getGreen(),
					pixelColor.getBlue(),
					null
				);

				// Increase the saturation value
				hsb[1] = Math.min(1.0f, hsb[1] * 1.5f); // You can adjust the value as needed

				int   rgb      = Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]);
				Color newColor = new Color(rgb);

				editedImage.setRGB(x, y, newColor.getRGB());
			}
		}

		return editedImage;
	}


	@Override
	public BufferedImage desaturate(BufferedImage image) throws IOException
	{
		BufferedImage editedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		int           r           = 0; // r - red value
		int           g           = 0; // g - green value
		int           b           = 0; // b - blue value

		boolean f = true;

		for (int y = 0; y < image.getHeight(); y++)
		{
			for (int x = 0; x < image.getWidth(); x++)
			{
				Color pixelColor = new Color(image.getRGB(x, y));

				float[] hsb = Color.RGBtoHSB(
					pixelColor.getRed(),
					pixelColor.getGreen(),
					pixelColor.getBlue(),
					null
				);

				// Decrease the saturation value
				hsb[1] = Math.max(0.0f, hsb[1] * 0.8f); // You can adjust the value as needed

				int   rgb      = Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]);
				Color newColor = new Color(rgb);

				editedImage.setRGB(x, y, newColor.getRGB());
			}
		}

		return editedImage;
	}


	@Override
	public BufferedImage retroNewspaper(BufferedImage image) throws IOException
	{
		BufferedImage editedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		int           rgb         = 0; // rbg - (red , green and blue) value
		int           r           = 0; // r - red value
		int           g           = 0; // g - green value
		int           b           = 0; // b - blue value

		boolean f = true;

		for (int y = 0; y < image.getHeight(); y++)
		{
			for (int x = 0; x < image.getWidth(); x++)
			{

				rgb = (int) image.getRGB(x, y);
				r   = (rgb & 0xFF);
				g   = (rgb & 0xFF);
				b   = (rgb & 0xFF);
				rgb = (int) ((r + g + b) / 3);
				rgb = (255 << 24) | (rgb << 16) | (rgb << 8) | rgb;
				editedImage.setRGB(x, y, rgb);
				f = !f;
			}
		}

		return editedImage;
	}

	@Override
	public BufferedImage sapphire(BufferedImage image) throws IOException
	{
		BufferedImage editedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		int           rgb         = 0; // rbg - (red , green and blue) value
		int           r           = 0; // r - red value
		int           g           = 0; // g - green value
		int           b           = 0; // b - blue value

		boolean f = true;

		for (int y = 0; y < image.getHeight(); y++)
		{
			for (int x = 0; x < image.getWidth(); x++)
			{


				Color pixelColor = new Color(image.getRGB(x, y));
				int   red        = pixelColor.getRed();
				int   green      = pixelColor.getGreen();
				int   blue       = pixelColor.getBlue();

				// Adjust color channels to create a desert-like effect
				red   = Math.min(255, (int) (red * 0.2)); // Enhance warm tones
				green = Math.min(255, (int) (green * 0.2));
				blue  = Math.min(255, (int) (blue * 1.2)); // Reduce cool tones

				Color newColor = new Color(red, green, blue);
				editedImage.setRGB(x, y, newColor.getRGB());
			}
		}

		return editedImage;
	}

	@Override
	public BufferedImage ruby(BufferedImage image) throws IOException
	{
		BufferedImage editedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		int           rgb         = 0; // rbg - (red , green and blue) value
		int           r           = 0; // r - red value
		int           g           = 0; // g - green value
		int           b           = 0; // b - blue value

//		boolean f = true;

		for (int y = 0; y < image.getHeight(); y++)
		{
			for (int x = 0; x < image.getWidth(); x++)
			{


				Color pixelColor = new Color(image.getRGB(x, y));
				int   red        = pixelColor.getRed();
				int   green      = pixelColor.getGreen();
				int   blue       = pixelColor.getBlue();

				// Adjust color channels to create a desert-like effect
				red   = Math.min(255, (int) (red * 1.2)); // Enhance warm tones
				green = Math.min(255, (int) (green * 0.2));
				blue  = Math.min(255, (int) (blue * 0.2)); // Reduce cool tones

				Color newColor = new Color(red, green, blue);
				editedImage.setRGB(x, y, newColor.getRGB());
			}
		}

		return editedImage;
	}

	@Override
	public BufferedImage emerald(BufferedImage image) throws IOException
	{

		BufferedImage editedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		int           rgb         = 0; // rbg - (red , green and blue) value
		int           r           = 0; // r - red value
		int           g           = 0; // g - green value
		int           b           = 0; // b - blue value

//		boolean f = true;

		for (int y = 0; y < image.getHeight(); y++)
		{
			for (int x = 0; x < image.getWidth(); x++)
			{

				Color pixelColor = new Color(image.getRGB(x, y));
				int   red        = pixelColor.getRed();
				int   green      = pixelColor.getGreen();
				int   blue       = pixelColor.getBlue();

				// Adjust color channels to create a desert-like effect
				red   = Math.min(255, (int) (red * 0.2)); // Enhance warm tones
				green = Math.min(255, (int) (green * 1.3));
				blue  = Math.min(255, (int) (blue * 0.2)); // Reduce cool tones

				Color newColor = new Color(red, green, blue);
				editedImage.setRGB(x, y, newColor.getRGB());
			}
		}

		return editedImage;
	}

	@Override
	public BufferedImage desert(BufferedImage image) throws IOException
	{
		BufferedImage editedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		int           rgb         = 0; // rbg - (red , green and blue) value
		int           r           = 0; // r - red value
		int           g           = 0; // g - green value
		int           b           = 0; // b - blue value

//		boolean f = true;

		for (int y = 0; y < image.getHeight(); y++)
		{
			for (int x = 0; x < image.getWidth(); x++)
			{

				Color pixelColor = new Color(image.getRGB(x, y));
				int   red        = pixelColor.getRed();
				int   green      = pixelColor.getGreen();
				int   blue       = pixelColor.getBlue();

				// Adjust color channels to create a desert-like effect
				red   = Math.min(255, (int) (red * 1.4)); // Enhance warm tones
				green = Math.min(255, (int) (green * 1.1));
				blue  = Math.min(255, (int) (blue * 0.8)); // Reduce cool tones

				Color newColor = new Color(red, green, blue);
				editedImage.setRGB(x, y, newColor.getRGB());
			}
		}

		return editedImage;
	}

	@Override
	public BufferedImage arctic(BufferedImage image) throws IOException
	{
		BufferedImage editedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		int           rgb         = 0; // rbg - (red , green and blue) value
		int           r           = 0; // r - red value
		int           g           = 0; // g - green value
		int           b           = 0; // b - blue value

//		boolean f = true;

		for (int y = 0; y < image.getHeight(); y++)
		{
			for (int x = 0; x < image.getWidth(); x++)
			{

				Color pixelColor = new Color(image.getRGB(x, y));
				int   red        = pixelColor.getRed();
				int   green      = pixelColor.getGreen();
				int   blue       = pixelColor.getBlue();

				// Adjust color channels to create a cold effect
				red   = Math.min(255, (int) (red * 0.8)); // Reduce warm tones
				green = Math.min(255, (int) (green * 0.9));
				blue  = Math.min(255, (int) (blue * 1.4)); // Enhance cool tones

				Color newColor = new Color(red, green, blue);
				editedImage.setRGB(x, y, newColor.getRGB());
			}
		}

		return editedImage;
	}

	@Override
	public BufferedImage blur(BufferedImage image, int blurStrength) throws IOException
	{
		BufferedImage editedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		int           rgb         = 0; // rbg - (red , green and blue) value
		int           r           = 0; // r - red value
		int           g           = 0; // g - green value
		int           b           = 0; // b - blue value

//		boolean f = true;
		int blurStr = blurStrength;

		for (int y = 0; y < image.getHeight(); y++)
		{
			for (int x = 0; x < image.getWidth(); x++)
			{

				int avgRed    = 0;
				int avgGreen  = 0;
				int avgBlue   = 0;
				int numPixels = 0;

				// Calculate average color of the pixel group
				for (int dy = 0; dy < blurStr; dy++)
				{
					for (int dx = 0; dx < blurStr; dx++)
					{
						int pixelX = x + dx;
						int pixelY = y + dy;

						if (pixelX < image.getWidth() && pixelY < image.getHeight())
						{
							Color pixelColor = new Color(image.getRGB(pixelX, pixelY));
							avgRed += pixelColor.getRed();
							avgGreen += pixelColor.getGreen();
							avgBlue += pixelColor.getBlue();
							numPixels++;
						}
					}
				}

				avgRed /= numPixels;
				avgGreen /= numPixels;
				avgBlue /= numPixels;

				Color newColor = new Color(avgRed, avgGreen, avgBlue);

				// Fill the pixel group with the calculated color
				for (int dy = 0; dy < blurStr; dy++)
				{
					for (int dx = 0; dx < blurStr; dx++)
					{
						int pixelX = x + dx;
						int pixelY = y + dy;

						if (pixelX < image.getWidth() && pixelY < image.getHeight())
						{
							editedImage.setRGB(pixelX, pixelY, newColor.getRGB());
						}
					}
				}
			}
		}

		return editedImage;
	}

	@Override
	public BufferedImage brighten(BufferedImage image, double brightness) throws IOException, ValueOutOfRangeException
	{
		BufferedImage editedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		int           rgb         = 0; // rbg - (red , green and blue) value
		int           r           = 0; // r - red value
		int           g           = 0; // g - green value
		int           b           = 0; // b - blue value

		double bri = brightness;
//		boolean f = true;


		// validating the value range
		if (bri < 1.0)
		{
			throw new ValueOutOfRangeException();
		}

		for (int y = 0; y < image.getHeight(); y++)
		{
			for (int x = 0; x < image.getWidth(); x++)
			{

				Color pixelColor = new Color(image.getRGB(x, y));
				int   red        = pixelColor.getRed();
				int   green      = pixelColor.getGreen();
				int   blue       = pixelColor.getBlue();

				// Adjust color channels to create a cold effect
				red   = Math.min(255, (int) (red * bri)); // Reduce warm tones
				green = Math.min(255, (int) (green * bri));
				blue  = Math.min(255, (int) (blue * bri)); // Enhance cool tones

				Color newColor = new Color(red, green, blue);
				editedImage.setRGB(x, y, newColor.getRGB());
			}
		}

		return editedImage;
	}

	@Override
	public BufferedImage darken(BufferedImage image, double darkness) throws IOException, ValueOutOfRangeException
	{
		BufferedImage editedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		int           rgb         = 0; // rbg - (red , green and blue) value
		int           r           = 0; // r - red value
		int           g           = 0; // g - green value
		int           b           = 0; // b - blue value

		double dar = darkness;

		// validating the value range
		if (dar > 1.0)
		{
			throw new ValueOutOfRangeException();
		}
//		boolean f = true;

		for (int y = 0; y < image.getHeight(); y++)
		{
			for (int x = 0; x < image.getWidth(); x++)
			{

				Color pixelColor = new Color(image.getRGB(x, y));
				int   red        = pixelColor.getRed();
				int   green      = pixelColor.getGreen();
				int   blue       = pixelColor.getBlue();

				// Adjust color channels to create a cold effect
				red   = Math.min(255, (int) (red * dar)); // Reduce warm tones
				green = Math.min(255, (int) (green * dar));
				blue  = Math.min(255, (int) (blue * dar)); // Enhance cool tones

				Color newColor = new Color(red, green, blue);
				editedImage.setRGB(x, y, newColor.getRGB());
			}
		}

		return editedImage;
	}

}
