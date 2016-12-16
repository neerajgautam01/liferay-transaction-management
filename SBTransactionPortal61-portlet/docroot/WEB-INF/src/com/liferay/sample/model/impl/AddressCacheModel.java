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

package com.liferay.sample.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.sample.model.Address;

import java.io.Serializable;

/**
 * The cache model class for representing Address in entity cache.
 *
 * @author NeerajGautam
 * @see Address
 * @generated
 */
public class AddressCacheModel implements CacheModel<Address>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{addressId=");
		sb.append(addressId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", address=");
		sb.append(address);
		sb.append(", contactNo=");
		sb.append(contactNo);
		sb.append("}");

		return sb.toString();
	}

	public Address toEntityModel() {
		AddressImpl addressImpl = new AddressImpl();

		addressImpl.setAddressId(addressId);
		addressImpl.setEmployeeId(employeeId);

		if (address == null) {
			addressImpl.setAddress(StringPool.BLANK);
		}
		else {
			addressImpl.setAddress(address);
		}

		addressImpl.setContactNo(contactNo);

		addressImpl.resetOriginalValues();

		return addressImpl;
	}

	public long addressId;
	public long employeeId;
	public String address;
	public int contactNo;
}