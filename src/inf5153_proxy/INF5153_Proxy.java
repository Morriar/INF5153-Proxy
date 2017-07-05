/*
 * Copyright 2017 Alexandre Terrasa <alexandre@moz-code.org>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package inf5153_proxy;

public class INF5153_Proxy {

    public static void main(String[] args) {
        Image image = new RealImage("test.png");
        image.display();
        
        image = new CachedProxy("test.png");
        // No loading until the load
        image.display();
        image.display(); // Only one loading
        
        image = new SmartProxy("test.png");
        // Loading low res waiting for the high res
        image.display();
        
        image = new RealImage("test.png");
        image.delete(); // allowed
        image = new ProtectedProxy("test.png");
        image.delete(); // rejected
    }
    
}
