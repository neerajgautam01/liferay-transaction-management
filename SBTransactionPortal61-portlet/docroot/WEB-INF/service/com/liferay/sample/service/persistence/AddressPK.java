/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.sample.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author NeerajGautam
 */
public class AddressPK implements Comparable<AddressPK>, Serializable {
	public long addressId;
	public long employeeId;

	public AddressPK() {
	}

	public AddressPK(long addressId, long employeeId) {
		this.addressId = addressId;
		this.employeeId = employeeId;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public int compareTo(AddressPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (addressId < pk.addressId) {
			value = -1;
		}
		else if (addressId > pk.addressId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (employeeId < pk.employeeId) {
			value = -1;
		}
		else if (employeeId > pk.employeeId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AddressPK)) {
			return false;
		}

		AddressPK pk = (AddressPK)obj;

		if ((addressId == pk.addressId) && (employeeId == pk.employeeId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(addressId) + String.valueOf(employeeId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("addressId");
		sb.append(StringPool.EQUAL);
		sb.append(addressId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("employeeId");
		sb.append(StringPool.EQUAL);
		sb.append(employeeId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}