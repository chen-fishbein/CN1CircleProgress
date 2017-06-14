# CN1CircleProgress
Circle Progress Library for [Codename One](https://github.com/codenameone/CodenameOne) apps
inspired from https://github.com/lzyzsd/CircleProgress

![alt tag](https://github.com/chen-fishbein/CN1CircleProgress/blob/master/image1.png)

## Sample Code:

        Form hi = new Form("Circle Progress");
        hi.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        final CircleProgress p = new CircleProgress();
        p.setProgress(100);
        p.setClockwise(true);
        p.setStartAngle(CircleProgress.START_9_OCLOCK);
        hi.add(p);
        
        final ArcProgress p2 = new ArcProgress();
        p2.setProgress(70);
        hi.add(p2);

        final CircleFilledProgress p3 = new CircleFilledProgress();
        p3.setProgress(70);
        hi.add(p3);
        
        Slider slider = new Slider();
        slider.setEditable(true);
        slider.addDataChangedListener(new DataChangedListener() {

            @Override
            public void dataChanged(int type, int index) {
                p.setProgress(index);
                p2.setProgress(index);
                p3.setProgress(index);
            }
        });
        hi.add(slider);
        
        hi.show();

## License:

The MIT License (MIT)

Copyright (c) 2015 Chen Fishbein

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.        
