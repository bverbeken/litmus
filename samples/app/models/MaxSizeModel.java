package models;

import play.data.validation.MaxSize;

import java.util.List;

public class MaxSizeModel {

	@MaxSize(4)
	public String maxString;

	@SuppressWarnings("UnusedDeclaration")
	@MaxSize(3)
	public List<String> maxList;

}
