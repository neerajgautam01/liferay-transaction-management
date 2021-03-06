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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Address}.
 * </p>
 *
 * @author    NeerajGautam
 * @see       Address
 * @generated
 */
public class AddressWrapper implements Address, ModelWrapper<Address> {
	public AddressWrapper(Address address) {
		_address = address;
	}

	public Class<?> getModelClass() {
		return Address.class;
	}

	public String getModelClassName() {
		return Address.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("addressId", getAddressId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("address", getAddress());
		attributes.put("contactNo", getContactNo());

		return attributes;
	}

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

	/**
	* Returns the primary key of this address.
	*
	* @return the primary key of this address
	*/
	public com.liferay.sample.service.persistence.AddressPK getPrimaryKey() {
		return _address.getPrimaryKey();
	}

	/**
	* Sets the primary key of this address.
	*
	* @param primaryKey the primary key of this address
	*/
	public void setPrimaryKey(
		com.liferay.sample.service.persistence.AddressPK primaryKey) {
		_address.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the address ID of this address.
	*
	* @return the address ID of this address
	*/
	public long getAddressId() {
		return _address.getAddressId();
	}

	/**
	* Sets the address ID of this address.
	*
	* @param addressId the address ID of this address
	*/
	public void setAddressId(long addressId) {
		_address.setAddressId(addressId);
	}

	/**
	* Returns the employee ID of this address.
	*
	* @return the employee ID of this address
	*/
	public long getEmployeeId() {
		return _address.getEmployeeId();
	}

	/**
	* Sets the employee ID of this address.
	*
	* @param employeeId the employee ID of this address
	*/
	public void setEmployeeId(long employeeId) {
		_address.setEmployeeId(employeeId);
	}

	/**
	* Returns the address of this address.
	*
	* @return the address of this address
	*/
	public java.lang.String getAddress() {
		return _address.getAddress();
	}

	/**
	* Sets the address of this address.
	*
	* @param address the address of this address
	*/
	public void setAddress(java.lang.String address) {
		_address.setAddress(address);
	}

	/**
	* Returns the contact no of this address.
	*
	* @return the contact no of this address
	*/
	public int getContactNo() {
		return _address.getContactNo();
	}

	/**
	* Sets the contact no of this address.
	*
	* @param contactNo the contact no of this address
	*/
	public void setContactNo(int contactNo) {
		_address.setContactNo(contactNo);
	}

	public boolean isNew() {
		return _address.isNew();
	}

	public void setNew(boolean n) {
		_address.setNew(n);
	}

	public boolean isCachedModel() {
		return _address.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_address.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _address.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _address.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_address.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _address.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_address.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AddressWrapper((Address)_address.clone());
	}

	public int compareTo(com.liferay.sample.model.Address address) {
		return _address.compareTo(address);
	}

	@Override
	public int hashCode() {
		return _address.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.sample.model.Address> toCacheModel() {
		return _address.toCacheModel();
	}

	public com.liferay.sample.model.Address toEscapedModel() {
		return new AddressWrapper(_address.toEscapedModel());
	}

	public com.liferay.sample.model.Address toUnescapedModel() {
		return new AddressWrapper(_address.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _address.toString();
	}

	public java.lang.String toXmlString() {
		return _address.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_address.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AddressWrapper)) {
			return false;
		}

		AddressWrapper addressWrapper = (AddressWrapper)obj;

		if (Validator.equals(_address, addressWrapper._address)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Address getWrappedAddress() {
		return _address;
	}

	public Address getWrappedModel() {
		return _address;
	}

	public void resetOriginalValues() {
		_address.resetOriginalValues();
	}

	private Address _address;
}