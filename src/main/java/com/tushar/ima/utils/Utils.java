package com.tushar.ima.utils;

import org.springframework.core.io.InputStreamResource;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class Utils
{
	// function to get the extension of a given file
	public static String getFileExtension(String fileName)
	{
		if (fileName == null || fileName.isEmpty())
		{
			return "";
		}

		int dotIndex = fileName.lastIndexOf('.');
		if (dotIndex > 0 && dotIndex < fileName.length() - 1)
		{
			return fileName.substring(dotIndex + 1).toLowerCase();
		}
		else
		{
			return "";
		}
	}

	// function to convert MultiPartFile to BufferedImage
	public static BufferedImage convertToBufferedImage(MultipartFile multipartFile) throws IOException
	{
		try (ByteArrayInputStream inputStream = new ByteArrayInputStream(multipartFile.getBytes()))
		{
			return ImageIO.read(inputStream);
		}
	}


	// function to convert BufferedImage to InputStreamResource
	public static InputStreamResource convertToInputStreamResource(BufferedImage bufferedImage) throws IOException
	{
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ImageIO.write(bufferedImage, "png", outputStream);

		byte[]               imageBytes  = outputStream.toByteArray();
		ByteArrayInputStream inputStream = new ByteArrayInputStream(imageBytes);

		return new InputStreamResource(inputStream);
	}

	// function to convert File to BufferedImage
	public static BufferedImage convertFileToBufferedImage(File file) throws IOException
	{
		return ImageIO.read(file);
	}

	// function to convert MultiPartFile to File
	public static File convertMultiPartFileToFile(MultipartFile multipartFile) throws IOException
	{
		byte[] fileBytes = multipartFile.getBytes();

		File convertedFile = File.createTempFile(multipartFile.getOriginalFilename(), null);

		try (FileOutputStream fos = new FileOutputStream(convertedFile))
		{
			fos.write(fileBytes);
		}

		return convertedFile;
	}
}
