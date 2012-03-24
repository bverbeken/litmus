package models;

import play.data.validation.InFuture;

import java.util.Date;

public class FutureModel {

	@InFuture
	public Date futureDate;

	@InFuture("2100-01-01")
	public Date dateAfter1Jan2100;


}

