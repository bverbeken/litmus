package models;

import play.data.validation.IPv4Address;
import play.data.validation.IPv6Address;

public class IpAddressModel {

	@IPv4Address
	public String ipV4Address;

	@IPv6Address
	public String ipV6Address;

}
