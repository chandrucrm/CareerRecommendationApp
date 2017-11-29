package com.goldenducks.carreco.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.collections.comparators.ReverseComparator;

public class CarRecoUtils {

	// This will sort list of objects based on property name and order passed to the method
	// list: List of objects
	// isAscending: true for ascending order
	// beanPropertyNames: property names according to which the list will be sorted
	@SuppressWarnings({ "rawtypes", "unchecked" })
	
	public static <T> void sort(List<T> list, boolean isAscending, String... beanPropertyNames) {
		Collection<Comparator<T>> beanComparatorCollection = new ArrayList<Comparator<T>>(beanPropertyNames.length);
		for (int i = 0; i < beanPropertyNames.length; i++) {
			beanComparatorCollection.add(new BeanComparator(beanPropertyNames[i]));
		}
		Comparator<T> finalComparator = ComparatorUtils.chainedComparator(beanComparatorCollection);
		if (!isAscending) {
			finalComparator = new ReverseComparator(finalComparator);
		}
		Collections.sort(list, finalComparator);
	}

	// This will get an object which contains the firstOccurence of a particular property value
	// list: list of objects
	// propertyName: property name 
	// propertyValue: property Value
	public static <T> T getFirst(List<T> list, String propertyName, String propertyValue) {
		T out = list.stream().filter(result -> {
			try {
				return (BeanUtils.getProperty(result, propertyName)+"").equalsIgnoreCase(propertyValue);
			} catch (Exception e) {
				return false;
			}
		}).findFirst().get();
		return out;
	}
}
