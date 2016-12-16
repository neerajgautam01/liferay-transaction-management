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

import com.liferay.sample.model.Employee;

import java.io.Serializable;

/**
 * The cache model class for representing Employee in entity cache.
 *
 * @author NeerajGautam
 * @see Employee
 * @generated
 */
public class EmployeeCacheModel implements CacheModel<Employee>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{employeeId=");
		sb.append(employeeId);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", middleName=");
		sb.append(middleName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", age=");
		sb.append(age);
		sb.append("}");

		return sb.toString();
	}

	public Employee toEntityModel() {
		EmployeeImpl employeeImpl = new EmployeeImpl();

		employeeImpl.setEmployeeId(employeeId);

		if (firstName == null) {
			employeeImpl.setFirstName(StringPool.BLANK);
		}
		else {
			employeeImpl.setFirstName(firstName);
		}

		if (middleName == null) {
			employeeImpl.setMiddleName(StringPool.BLANK);
		}
		else {
			employeeImpl.setMiddleName(middleName);
		}

		if (lastName == null) {
			employeeImpl.setLastName(StringPool.BLANK);
		}
		else {
			employeeImpl.setLastName(lastName);
		}

		employeeImpl.setAge(age);

		employeeImpl.resetOriginalValues();

		return employeeImpl;
	}

	public long employeeId;
	public String firstName;
	public String middleName;
	public String lastName;
	public int age;
}