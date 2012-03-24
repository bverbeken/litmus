package models;

import play.data.validation.IsTrue;

import java.math.BigDecimal;

public class IsTrueModel {


	@IsTrue
	public boolean trueBoolean;

	@IsTrue
	public String trueString;

	@IsTrue
	public Integer trueInteger;

	@IsTrue
	public Long trueLong;

	@IsTrue
	public Double trueDouble;

	@IsTrue
	public BigDecimal trueBigDecimal;

	@IsTrue
	public Float trueFloat;


}
