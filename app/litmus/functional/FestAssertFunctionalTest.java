/*
 * Copyright 2012 Ben Verbeken
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package litmus.functional;

import org.fest.assertions.*;
import org.jsoup.nodes.Element;
import play.mvc.Http;

import java.awt.image.BufferedImage;
import java.io.File;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

abstract class FestAssertFunctionalTest extends play.test.FunctionalTest {

	protected ResponseAssert assertThat(Response response) {
		return FunctionalAssertions.assertThat(response);
	}

	protected CookieAssert assertThat(Http.Cookie cookie) {
		return FunctionalAssertions.assertThat(cookie);
	}

	protected HtmlAssert assertThat(Html html) {
		return FunctionalAssertions.assertThat(html);
	}

	protected HtmlElementAssert assertThat(Element element) {
		return FunctionalAssertions.assertThat(element);
	}


	/* ************** FEST *************** */
	public static BigDecimalAssert assertThat(BigDecimal actual) {
		return Assertions.assertThat(actual);
	}

	public static BooleanAssert assertThat(boolean actual) {
		return Assertions.assertThat(actual);
	}

	public static BooleanAssert assertThat(Boolean actual) {
		return Assertions.assertThat(actual);
	}

	public static BooleanArrayAssert assertThat(boolean[] actual) {
		return Assertions.assertThat(actual);
	}

	public static ImageAssert assertThat(BufferedImage actual) {
		return Assertions.assertThat(actual);
	}

	public static ByteAssert assertThat(byte actual) {
		return Assertions.assertThat(actual);
	}

	public static ByteAssert assertThat(Byte actual) {
		return Assertions.assertThat(actual);
	}

	public static ByteArrayAssert assertThat(byte[] actual) {
		return Assertions.assertThat(actual);
	}

	public static CharAssert assertThat(char actual) {
		return Assertions.assertThat(actual);
	}

	public static CharAssert assertThat(Character actual) {
		return Assertions.assertThat(actual);
	}

	public static CharArrayAssert assertThat(char[] actual) {
		return Assertions.assertThat(actual);
	}

	public static CollectionAssert assertThat(Collection<?> actual) {
		return Assertions.assertThat(actual);
	}

	public static ListAssert assertThat(List<?> actual) {
		return Assertions.assertThat(actual);
	}

	public static DoubleAssert assertThat(double actual) {
		return Assertions.assertThat(actual);
	}

	public static DoubleAssert assertThat(Double actual) {
		return Assertions.assertThat(actual);
	}

	public static DoubleArrayAssert assertThat(double[] actual) {
		return Assertions.assertThat(actual);
	}

	public static FileAssert assertThat(File actual) {
		return Assertions.assertThat(actual);
	}

	public static FloatAssert assertThat(float actual) {
		return Assertions.assertThat(actual);
	}

	public static FloatAssert assertThat(Float actual) {
		return Assertions.assertThat(actual);
	}

	public static FloatArrayAssert assertThat(float[] actual) {
		return Assertions.assertThat(actual);
	}

	public static IntAssert assertThat(int actual) {
		return Assertions.assertThat(actual);
	}

	public static IntAssert assertThat(Integer actual) {
		return Assertions.assertThat(actual);
	}

	public static IntArrayAssert assertThat(int[] actual) {
		return Assertions.assertThat(actual);
	}

	public static IteratorAssert assertThat(Iterable<?> actual) {
		return Assertions.assertThat(actual);
	}

	public static IteratorAssert assertThat(Iterator<?> actual) {
		return Assertions.assertThat(actual);
	}

	public static LongAssert assertThat(long actual) {
		return Assertions.assertThat(actual);
	}

	public static LongAssert assertThat(Long actual) {
		return Assertions.assertThat(actual);
	}

	public static LongArrayAssert assertThat(long[] actual) {
		return Assertions.assertThat(actual);
	}

	public static MapAssert assertThat(Map<?, ?> actual) {
		return Assertions.assertThat(actual);
	}

	public static ObjectAssert assertThat(Object actual) {
		return Assertions.assertThat(actual);
	}

	public static ObjectArrayAssert assertThat(Object[] actual) {
		return Assertions.assertThat(actual);
	}

	public static ShortAssert assertThat(short actual) {
		return Assertions.assertThat(actual);
	}

	public static ShortAssert assertThat(Short actual) {
		return Assertions.assertThat(actual);
	}

	public static ShortArrayAssert assertThat(short[] actual) {
		return Assertions.assertThat(actual);
	}

	public static StringAssert assertThat(String actual) {
		return Assertions.assertThat(actual);
	}

	public static <T extends AssertExtension> T assertThat(T assertion) {
		return Assertions.assertThat(assertion);
	}

	public static ThrowableAssert assertThat(Throwable actual) {
		return Assertions.assertThat(actual);
	}

}
