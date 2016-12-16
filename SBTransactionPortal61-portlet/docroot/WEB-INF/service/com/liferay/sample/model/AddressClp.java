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

package com.liferay.sample.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.sample.service.AddressLocalServiceUtil;
import com.liferay.sample.service.ClpSerializer;
import com.liferay.sample.service.persistence.AddressPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author NeerajGautam
 */
public class AddressClp extends BaseModelImpl<Address> implements Address {
	public AddressClp() {
	}

	public Class<?> getModelClass() {
		return Address.class;
	}

	public String getModelClassName() {
		return Address.class.getName();
	}

	public AddressPK getPrimaryKey() {
		return new AddressPK(_addressId, _employeeId);
	}

	public void setPrimaryKey(AddressPK primaryKey) {
		setAddressId(primaryKey.addressId);
		setEmployeeId(primaryKey.employeeId);
	}

	public Serializable getPrimaryKeyObj() {
		return new AddressPK(_addressId, _employeeId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((AddressPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("addressId", getAddressId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("address", getAddress());
		attributes.put("contactNo", getContactNo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long addressId = (Long)attributes.get("addressId");

		if (addressId != null) {
			setAddressId(addressId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		Integer contactNo = (Integer)attributes.get("contactNo");

		if (contactNo != null) {
			setContactNo(contactNo);
		}
	}

	public long getAddressId() {
		return _addressId;
	}

	public void setAddressId(long addressId) {
		_addressId = addressId;

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setAddressId", long.class);

				method.invoke(_addressRemoteModel, addressId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeId", long.class);

				method.invoke(_addressRemoteModel, employeeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress", String.class);

				method.invoke(_addressRemoteModel, address);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public int getContactNo() {
		return _contactNo;
	}

	public void setContactNo(int contactNo) {
		_contactNo = contactNo;

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setContactNo", int.class);

				method.invoke(_addressRemoteModel, contactNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAddressRemoteModel() {
		return _addressRemoteModel;
	}

	public void setAddressRemoteModel(BaseModel<?> addressRemoteModel) {
		_addressRemoteModel = addressRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _addressRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_addressRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			AddressLocalServiceUtil.addAddress(this);
		}
		else {
			AddressLocalServiceUtil.updateAddress(this);
		}
	}

	@Override
	public Address toEscapedModel() {
		return (Address)ProxyUtil.newProxyInstance(Address.class.getClassLoader(),
			new Class[] { Address.class }, new AutoEscapeBeanHandler(this));
	}

	public Address toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		AddressClp clone = new AddressClp();

		clone.setAddressId(getAddressId());
		clone.setEmployeeId(getEmployeeId());
		clone.setAddress(getAddress());
		clone.setContactNo(getContactNo());

		return clone;
	}

	public int compareTo(Address address) {
		AddressPK primaryKey = address.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AddressClp)) {
			return false;
		}

		AddressClp address = (AddressClp)obj;

		AddressPK primaryKey = address.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{addressId=");
		sb.append(getAddressId());
		sb.append(", employeeId=");
		sb.append(getEmployeeId());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append(", contactNo=");
		sb.append(getContactNo());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.liferay.sample.model.Address");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>addressId</column-name><column-value><![CDATA[");
		sb.append(getAddressId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactNo</column-name><column-value><![CDATA[");
		sb.append(getContactNo());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _addressId;
	private long _employeeId;
	private String _address;
	private int _contactNo;
	private BaseModel<?> _addressRemoteModel;
}