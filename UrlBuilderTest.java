package kr.co.freeism;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.common.collect.Lists;

/**
 * @author freeism
 * @since 15. 4. 23 오전 11:47
 * @see http://www.leveluplunch.com/java/examples/build-convert-map-to-query-string/
 */
public class UrlBuilderTest {
	@Test
	public void test() throws Exception {
		UriComponents components = UriComponentsBuilder.fromUriString("http://www.freeism.co.kr/test?id=1000").query("name=freeism").build();
		System.out.println(components.toUriString());

		UriComponents components2 = UriComponentsBuilder.fromUriString("http://www.freeism.co.kr/test").query("name=freeism").build();
		System.out.println(components2.toUriString());

		UriComponents components3 = UriComponentsBuilder.fromUriString("http://www.freeism.co.kr/test?id=1000").query(
			"name=freeism&email=freeism@freeism.co.kr").build();
		System.out.println(components3.toUriString());

		List<NameValuePair> list = Lists.newArrayList();
		list.add(new BasicNameValuePair("name", "freeism"));

		URIBuilder builder = new URIBuilder("http://www.freeism.co.kr/test?id=1000").addParameters(list);
		System.out.println(builder.build());

		URIBuilder builder2 = new URIBuilder("http://www.freeism.co.kr/test").addParameters(list);
		System.out.println(builder2.build());

		list.add(new BasicNameValuePair("email", "freeism@freeism.co.kr"));

		URIBuilder builder3 = new URIBuilder("http://www.freeism.co.kr/test?id=1000").addParameters(list);
		System.out.println(builder3.build());
	}
}
