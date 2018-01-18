package com.vbj.rbc.parent;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class ParentTestUtils {

	public static MultiValueMap<String, String> createRequestParentDetails(String child, String parent) {
		MultiValueMap<String, String> parametersMap = new LinkedMultiValueMap<String, String>();

		parametersMap.add("child", child);
		parametersMap.add("parent", parent);

		return parametersMap;
	}

}
