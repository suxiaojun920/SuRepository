package com.hellojava.jackson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hellojava.entity.Book;

public class JsonOption {
	public void write(Object obj,String path) {
		ObjectMapper mapper=new ObjectMapper();
		try {
			String json=mapper.writeValueAsString(obj);
			File file=new File(path);
			PrintWriter pw=new PrintWriter(file);
			pw.write(json);
			pw.flush();
			pw.close();
		} catch (JsonProcessingException|FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 第一张反序列化Json 数据
	 * @param path
	 * @return
	 */
	public Object read(String path){
		File file=new File(path);
		Object obj=null;
		if(file.exists()) {
			ObjectMapper mapper=new ObjectMapper();
			try {
				obj=mapper.readValue(new FileInputStream(path),new TypeReference<List<Book>>() {});
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}
	
	/**
	 * 反序列化第二张方式
	 * @param path
	 * @param collectionClass
	 * @param elementClass
	 * @return
	 */
	public Object read1(String path,Class collectionClass,Class elementClass) {
		File file=new File(path);
		Object obj=null;
		if(file.exists()) {
			ObjectMapper mapper=new ObjectMapper();
			JavaType type=mapper.getTypeFactory().constructParametricType(collectionClass	, elementClass);
			try {
				obj=mapper.readValue(new FileInputStream(file), type);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}
}
