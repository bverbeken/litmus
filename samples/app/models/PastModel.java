package models;

import play.data.validation.InPast;

import java.util.Date;

public class PastModel {

	@InPast
	public Date pastDate;

	@InPast("2012-12-31")
	public Date dateBefore31Dec2012;


}
