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

package controllers;

import play.data.validation.MinSize;
import play.data.validation.Required;
import play.data.validation.Validation;
import play.mvc.Controller;

public class HtmlController extends Controller {

	public static void aPage() {
		render();
	}

	public static void helloWorld() {
		render();
	}

	public static void sayHello(@Required @MinSize(4) String name) {
		if (Validation.hasErrors()) {
			params.flash();
			Validation.keep();
			helloWorld();
		}
        String msg = "Hello " + name + "!";
		render(msg);
	}


}
