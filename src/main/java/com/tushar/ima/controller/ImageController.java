package com.tushar.ima.controller;

import com.tushar.ima.exceptions.ValueOutOfRangeException;
import com.tushar.ima.service.ImageService;
import com.tushar.ima.utils.Utils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/image/")
@Tag(name = "IMAGE")
public class ImageController
{

	@Autowired
	private ImageService imageService; // image service object
	@Value("${project.image}") // file path variable from applications.properties
	private String       path;

	// test endpoint
	@CrossOrigin
	@GetMapping(value = "/test")
	@Operation(description = "TEST ENDPOINT", summary = "RETURNS THE SAME IMAGE")
	public void test(@RequestParam("image") MultipartFile image, HttpServletResponse response) throws IOException
	{

		String fileName = null;

		File          file        = Utils.convertMultiPartFileToFile(image); // location of the image as a File
		BufferedImage img         = Utils.convertFileToBufferedImage(file); //  image the user uploaded
		BufferedImage editedImage = imageService.test(img);

		InputStreamResource isr = Utils.convertToInputStreamResource(editedImage); // InputStreamResource from BufferedImage

		response.setContentType((MediaType.IMAGE_JPEG_VALUE));
		StreamUtils.copy(isr.getContentAsByteArray(), response.getOutputStream());

	}

	@CrossOrigin
	@GetMapping("/greyscale")
	@Operation(description = "GREYSCALE FILTER", summary = "RETURNS THE GREYSCALE VERSION OF THE IMAGE")
	public void greyScale(@RequestParam("image") MultipartFile image, HttpServletResponse response) throws IOException
	{

		String fileName = null;

		File          file        = Utils.convertMultiPartFileToFile(image); // location of the image as a File
		BufferedImage img         = Utils.convertFileToBufferedImage(file); //  image the user uploaded
		BufferedImage editedImage = imageService.greyscale(img);

		InputStreamResource isr = Utils.convertToInputStreamResource(editedImage); // InputStreamResource from BufferedImage

		response.setContentType((MediaType.IMAGE_JPEG_VALUE));
		StreamUtils.copy(isr.getContentAsByteArray(), response.getOutputStream());

	}

	@CrossOrigin
	@GetMapping(value = "/saturate")
	@Operation(description = "SATURATION FILTER", summary = "RETURNS THE IMAGE WITH SATURATED COLORS")
	public void saturate(@RequestParam("image") MultipartFile image, HttpServletResponse response) throws IOException
	{

		String fileName = null;

		File          file        = Utils.convertMultiPartFileToFile(image); // location of the image as a File
		BufferedImage img         = Utils.convertFileToBufferedImage(file); //  image the user uploaded
		BufferedImage editedImage = imageService.saturate(img);

		InputStreamResource isr = Utils.convertToInputStreamResource(editedImage); // InputStreamResource from BufferedImage

		response.setContentType((MediaType.IMAGE_JPEG_VALUE));
		StreamUtils.copy(isr.getContentAsByteArray(), response.getOutputStream());


	}

	@CrossOrigin
	@GetMapping(value = "/desaturate")
	@Operation(description = "DESATURATION FILTER", summary = "RETURNS THE IMAGE WITH DESATURATED COLORS")
	public void desaturate(@RequestParam("image") MultipartFile image, HttpServletResponse response) throws IOException
	{

		String fileName = null;

		File          file        = Utils.convertMultiPartFileToFile(image); // location of the image as a File
		BufferedImage img         = Utils.convertFileToBufferedImage(file); //  image the user uploaded
		BufferedImage editedImage = imageService.desaturate(img);

		InputStreamResource isr = Utils.convertToInputStreamResource(editedImage); // InputStreamResource from BufferedImage

		response.setContentType((MediaType.IMAGE_JPEG_VALUE));
		StreamUtils.copy(isr.getContentAsByteArray(), response.getOutputStream());


	}

	@CrossOrigin
	@GetMapping(value = "/retroNewspaper")
	@Operation(description = "RETRO NEWSPAPER FILTER", summary = "RETURNS THE IMAGE WITH A RETRO NEWSPAPER FILTER")
	public void retroNewspaper(@RequestParam("image") MultipartFile image, HttpServletResponse response) throws IOException
	{

		String fileName = null;

		File          file        = Utils.convertMultiPartFileToFile(image); // location of the image as a File
		BufferedImage img         = Utils.convertFileToBufferedImage(file); //  image the user uploaded
		BufferedImage editedImage = imageService.retroNewspaper(img);

		InputStreamResource isr = Utils.convertToInputStreamResource(editedImage); // InputStreamResource from BufferedImage

		response.setContentType((MediaType.IMAGE_JPEG_VALUE));
		StreamUtils.copy(isr.getContentAsByteArray(), response.getOutputStream());


	}

	@CrossOrigin
	@GetMapping(value = "/sapphire")
	@Operation(description = "SAPPHIRE FILTER", summary = "RETURNS THE IMAGE WITH SAPPHIRE FILTER")
	public void sapphire(@RequestParam("image") MultipartFile image, HttpServletResponse response) throws IOException
	{

		String fileName = null;

		File          file        = Utils.convertMultiPartFileToFile(image); // location of the image as a File
		BufferedImage img         = Utils.convertFileToBufferedImage(file); //  image the user uploaded
		BufferedImage editedImage = imageService.sapphire(img);

		InputStreamResource isr = Utils.convertToInputStreamResource(editedImage); // InputStreamResource from BufferedImage

		response.setContentType((MediaType.IMAGE_JPEG_VALUE));
		StreamUtils.copy(isr.getContentAsByteArray(), response.getOutputStream());


	}

	@CrossOrigin
	@GetMapping(value = "/ruby")
	@Operation(description = "RUBY FILTER", summary = "RETURNS THE IMAGE WITH RUBY FILTER")
	public void ruby(@RequestParam("image") MultipartFile image, HttpServletResponse response) throws IOException
	{

		String fileName = null;

		File          file        = Utils.convertMultiPartFileToFile(image); // location of the image as a File
		BufferedImage img         = Utils.convertFileToBufferedImage(file); //  image the user uploaded
		BufferedImage editedImage = imageService.ruby(img);

		InputStreamResource isr = Utils.convertToInputStreamResource(editedImage); // InputStreamResource from BufferedImage

		response.setContentType((MediaType.IMAGE_JPEG_VALUE));
		StreamUtils.copy(isr.getContentAsByteArray(), response.getOutputStream());


	}

	@CrossOrigin
	@GetMapping(value = "/emerald")
	@Operation(description = "EMERALD FILTER", summary = "RETURNS THE IMAGE WITH EMERALD FILTER")
	public void emerald(@RequestParam("image") MultipartFile image, HttpServletResponse response) throws IOException
	{

		String fileName = null;

		File          file        = Utils.convertMultiPartFileToFile(image); // location of the image as a File
		BufferedImage img         = Utils.convertFileToBufferedImage(file); //  image the user uploaded
		BufferedImage editedImage = imageService.emerald(img);

		InputStreamResource isr = Utils.convertToInputStreamResource(editedImage); // InputStreamResource from BufferedImage

		response.setContentType((MediaType.IMAGE_JPEG_VALUE));
		StreamUtils.copy(isr.getContentAsByteArray(), response.getOutputStream());


	}

	@CrossOrigin
	@GetMapping(value = "/desert")
	@Operation(description = "DESERT FILTER", summary = "RETURNS THE IMAGE WITH DESERT FILTER")
	public void desert(@RequestParam("image") MultipartFile image, HttpServletResponse response) throws IOException
	{

		String fileName = null;

		File          file        = Utils.convertMultiPartFileToFile(image); // location of the image as a File
		BufferedImage img         = Utils.convertFileToBufferedImage(file); //  image the user uploaded
		BufferedImage editedImage = imageService.desert(img);

		InputStreamResource isr = Utils.convertToInputStreamResource(editedImage); // InputStreamResource from BufferedImage

		response.setContentType((MediaType.IMAGE_JPEG_VALUE));
		StreamUtils.copy(isr.getContentAsByteArray(), response.getOutputStream());


	}

	@CrossOrigin
	@GetMapping(value = "/arctic")
	@Operation(description = "ARCTIC FILTER", summary = "RETURNS THE IMAGE WITH ARCTIC FILTER")
	public void arctic(@RequestParam("image") MultipartFile image, HttpServletResponse response) throws IOException
	{

		String fileName = null;

		File          file        = Utils.convertMultiPartFileToFile(image); // location of the image as a File
		BufferedImage img         = Utils.convertFileToBufferedImage(file); //  image the user uploaded
		BufferedImage editedImage = imageService.arctic(img);

		InputStreamResource isr = Utils.convertToInputStreamResource(editedImage); // InputStreamResource from BufferedImage

		response.setContentType((MediaType.IMAGE_JPEG_VALUE));
		StreamUtils.copy(isr.getContentAsByteArray(), response.getOutputStream());


	}

	@CrossOrigin
	@GetMapping(value = "/blur")
	@Operation(description = "BLUR FILTER", summary = "RETURNS THE IMAGE WITH BLUR FILTER, TAKES A INT BLUR VALUE")
	public void blur(@RequestParam("blurStr") int blurStr, @RequestParam("image") MultipartFile image, HttpServletResponse response) throws IOException
	{

		String fileName = null;

		File          file        = Utils.convertMultiPartFileToFile(image); // location of the image as a File
		BufferedImage img         = Utils.convertFileToBufferedImage(file); //  image the user uploaded
		BufferedImage editedImage = imageService.blur(img, blurStr);

		InputStreamResource isr = Utils.convertToInputStreamResource(editedImage); // InputStreamResource from BufferedImage

		response.setContentType((MediaType.IMAGE_JPEG_VALUE));
		StreamUtils.copy(isr.getContentAsByteArray(), response.getOutputStream());


	}

	@CrossOrigin
	@GetMapping(value = "/brighten")
	@Operation(description = "BRIGHTNESS FILTER", summary = "RETURNS THE IMAGE WITH BRIGHTNESS FILTER, TAKES A DOUBLE BRIGHTNESS VALUE")
	public void brighten(@RequestParam("brightness") double brightness, @RequestParam("image") MultipartFile image, HttpServletResponse response) throws IOException, ValueOutOfRangeException
	{

		String fileName = null;

		File          file        = Utils.convertMultiPartFileToFile(image); // location of the image as a File
		BufferedImage img         = Utils.convertFileToBufferedImage(file); //  image the user uploaded
		BufferedImage editedImage = imageService.brighten(img, brightness);

		InputStreamResource isr = Utils.convertToInputStreamResource(editedImage); // InputStreamResource from BufferedImage

		response.setContentType((MediaType.IMAGE_JPEG_VALUE));
		StreamUtils.copy(isr.getContentAsByteArray(), response.getOutputStream());


	}


	@CrossOrigin
	@GetMapping(value = "/darken")
	@Operation(description = "DARKNESS FILTER", summary = "RETURNS THE IMAGE WITH DARKNESS FILTER, TAKES A DOUBLE DARKNESS VALUE")
	public void darken(@RequestParam("darkness") double darkness, @RequestParam("image") MultipartFile image, HttpServletResponse response) throws IOException, ValueOutOfRangeException
	{

		String fileName = null;

		File          file        = Utils.convertMultiPartFileToFile(image); // location of the image as a File
		BufferedImage img         = Utils.convertFileToBufferedImage(file); //  image the user uploaded
		BufferedImage editedImage = imageService.darken(img, darkness);

		InputStreamResource isr = Utils.convertToInputStreamResource(editedImage); // InputStreamResource from BufferedImage

		response.setContentType((MediaType.IMAGE_JPEG_VALUE));
		StreamUtils.copy(isr.getContentAsByteArray(), response.getOutputStream());


	}

}






























