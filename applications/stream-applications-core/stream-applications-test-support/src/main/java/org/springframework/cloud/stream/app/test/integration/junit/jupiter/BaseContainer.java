/*
 * Copyright 2020-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.stream.app.test.integration.junit.jupiter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.function.Supplier;

import static org.springframework.cloud.stream.app.test.integration.StreamAppContainerTestUtils.SPRINGCLOUDSTREAM_REPOSITOTRY;

/**
 * Marker for a
 * {@link org.springframework.cloud.stream.app.test.integration.StreamAppContainer}
 * configured for Kafka or Rabbit MQ that can be injected into tests that use
 * {code @ExtendWith(BaseContainerExtension.class}. Both the field and containing class
 * must be public.
 * @author David Turanski
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface BaseContainer {

	/**
	 * @return the version or image tag.
	 */
	String version() default "";

	/**
	 * @return A {@code Class<? extends Supplier<String>>} used to set the version
	 * dynamically.
	 */
	Class<? extends Supplier<String>> versionSupplier() default NullVersionSupplier.class;

	/**
	 * @return the image name.
	 */
	String name() default "";

	/**
	 * @return the type of Spring Cloud Stream binder used by the application.
	 */
	Binder binder();

	/**
	 * @return the Docker repository name of the image.
	 */
	String repository() default SPRINGCLOUDSTREAM_REPOSITOTRY;
}
