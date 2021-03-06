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

public class SmartProxy implements Image {
    
    private Image realImage = null;
    
    private final String fileName;

    public SmartProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        System.out.println("Displaying low quality for " + fileName);
        loadRealImage();
        realImage.display();
    }

    @Override
    public void delete() {
        loadRealImage();
        realImage.delete();
    }
    
    private void loadRealImage() {
        if(realImage == null) {
            realImage = new RealImage(fileName);
        }
    }
    
}
