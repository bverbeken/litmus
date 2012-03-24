package models;

import play.data.validation.IPv4Address;

public class IpAddressModel {

	@IPv4Address
	public String ipV4Address;

	//TODO	@IPv6Address
	//	public String ipV6Address;

}
