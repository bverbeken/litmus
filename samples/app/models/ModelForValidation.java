package models;

import play.data.validation.*;

import java.math.BigDecimal;
import java.util.Date;

public class ModelForValidation {

	@Email
	public String email;

//	EQUALS("equals"),

	@InFuture
	public Date futureDate;

	@InFuture("2100-01-01")
	public Date dateAfter1Jan2100;

	@InPast
	public Date pastDate;

	@InPast("2012-12-31")
	public Date dateBefore31Dec2012;

	@IPv4Address
	public String ipV4Address;

	//TODO	@IPv6Address
	//	public String ipV6Address;

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

	@Match("[0-9]*")
	public String matchingString;

	@Max(10)
	public int maxInt;


	// MAX_SIZE("maxSize"),

	@Min(10)
	public int minInt;

	// MIN_SIZE("minSize"),

	// PASSWORD --> what is this used for? Not for validation, I guess..?

	@Phone
	public String phone;

	@Range(min = 10, max = 20)
	public int between10And20;


	@Required
	public String requiredString;

	//	TODO @Unique
	//	public String uniqueString;

	@URL
	public String url;

	@Valid
	public Person validObject;


}
