package org.xsl781.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.graphics.Bitmap;

/**
 * 简单的网络 操作<br>
 * <b>创建时间</b> 2015-7-14
 * @version 1.0
 */
public final class NetUtil {

	public static BufferedReader bufferedReader(String url) throws IOException,
			ClientProtocolException, UnsupportedEncodingException {
		HttpGet get = new HttpGet(url);
		DefaultHttpClient client = new DefaultHttpClient();
		HttpResponse response = client.execute(get);
		HttpEntity entity = response.getEntity();
		InputStream stream = entity.getContent();
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "GBK"));
		return reader;
	}

	public static InputStream inputStreamFromUrl(String url) throws IOException,
			ClientProtocolException {
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(url);
		HttpResponse response = client.execute(get);
		HttpEntity entity = response.getEntity();
		InputStream stream = entity.getContent();
		return stream;
	}

	public static byte[] getBytesFromUrl(String url) throws Exception {
		InputStream in = inputStreamFromUrl(url);
		return FileUtils.readStream2Bytes(in);
	}

	public static Bitmap saveBitmapLocal(String bitmapUrl, File bitmapFile) throws IOException,
			FileNotFoundException, ClientProtocolException {
		Bitmap resultBitmap;
		downloadFileIfNotExists(bitmapUrl, bitmapFile);
		resultBitmap = BitmapUtil.bitmapFromFile(bitmapFile);
		return resultBitmap;
	}

	public static void downloadFileIfNotExists(String url, File toFile) throws IOException {
		if (toFile.exists()) {
		} else {
			downloadFile(url, toFile);
		}
	}

	public static void downloadFile(String url, File toFile) throws IOException {
		toFile.createNewFile();
		FileOutputStream outputStream = new FileOutputStream(toFile);
		InputStream inputStream = inputStreamFromUrl(url);
		FileUtils.inputToOutput(outputStream, inputStream);
	}

	public static Bitmap getBitmapFromUrl(String logoUrl, String filmEnName, String appPath)
			throws IOException, FileNotFoundException, ClientProtocolException {
		Bitmap resultBitmap;
		String logoPath = appPath + "logo/";
		File dir = new File(logoPath);
		if (dir.exists() == false) {
			dir.mkdirs();
		}
		File logoLocalFile = new File(logoPath + filmEnName + ".jpg");
		resultBitmap = saveBitmapLocal(logoUrl, logoLocalFile);
		return resultBitmap;
	}
}