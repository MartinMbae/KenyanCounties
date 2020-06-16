# Kenyan Counties

KenyanCounties is an android library that displays all the 47 counties in Kenya for selection.

Each county in this library has;
 
- Name eg Mombasa
- ID eg 1
- County Number eg 001
- Flag




## Installation

Add this library to your dependencies

```bash
    implementation 'com.martinmbae.kenyan.47counties:library:1.0.3'
```

## Usage

Add the following imports to your project

```java
import studios.luxurious.kenya47counties.activities.CountyReturned;
import studios.luxurious.kenya47counties.activities.Kenya47Counties;
import studios.luxurious.kenya47counties.models.County;
```

To the display all counties, call the method 

```java
   Kenya47Counties.showAllCountiesDialog(MainActivity.this, 
                        "Select your county",
                        true, //Display county number
                        true, //Display County Flags
                        false, //Order alphabetically. When false it will order by county number
                        new CountyReturned() {
                    @Override
                    public void onSelectedCounty(County selectedCounty) {
                        
                        String countyName = selectedCounty.getName(); //eg Nairobi
                        int countyId = selectedCounty.getId();  //eg 47
                        String countyNumber = selectedCounty.getFormattedCountyNumber(); //eg 047 
                        Drawable countyFlag = selectedCounty.getFlag(); 

                        String selectionText = countyNumber + " - " + countyName;
                        selectedCountyTextview.setText(selectionText);
                        flagImageView.setImageDrawable(countyFlag);
                    }
                });

```

## Screenshots

<img src="https://github.com/MartinMbae/KenyanCounties/blob/master/screenshots/scr1.png" width="300" height="auto"> 

##### Ordered by county number
<img src="https://github.com/MartinMbae/KenyanCounties/blob/master/screenshots/scr2.png" width="300" height="auto" > <img src="https://github.com/MartinMbae/KenyanCounties/blob/master/screenshots/scr3.png" width="300" height="auto">

##### Ordered alphabetically
<img src="https://github.com/MartinMbae/KenyanCounties/blob/master/screenshots/scr4.png" width="300" height="auto"><img src="https://github.com/MartinMbae/KenyanCounties/blob/master/screenshots/scr5.png" width="300" height="auto">


## License
MIT License

```
Copyright (c) [year] [fullname]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

```
