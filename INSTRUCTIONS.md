For this exercise, I created an Andy Warhol-inspired photo collage by manipulating the famous Mona Lisa image. The program I developed displays multiple versions of the Mona Lisa, each adjusted in terms of size and color to imitate Warhol's style.

1. Top Left Corner
First, I started by resizing the Mona Lisa image so that it appears smaller, specifically one-fourth of its original size, and placed it in the top left corner of the canvas. I adjusted the pixel values so that each point in the smaller image corresponded to a scaled-down version of the original. For instance, the value at point (0, 0) in the smaller image corresponds to (0, 0) in the original image, and similarly for other coordinates. This scaling down worked both horizontally and vertically.

2. Creating the Grid
Next, I modified the program to replicate the smaller image four times to fill the canvas, forming a 2x2 grid. Each small version of the Mona Lisa was placed in different corners of the canvas. The first one appeared at the top left (coordinates 0, 0), the second at the top right (width/2, 0), the third at the bottom left (0, height/2), and the last at the bottom right (width/2, height/2). This created a visually balanced collage.

3. Negative Image
Finally, I added a twist by applying a negative filter to the image. For each pixel in the image, I reversed the color values by subtracting them from 1. This created the effect of a photographic negative, where the colors are inverted. For example, for the red channel, I used red = 1.0 - red. This negative effect gave the collage a unique and striking appearance, reminiscent of Andy Warhol's bold use of color contrasts.

And that’s how I recreated a Warhol-style interpretation of the Mona Lisa, featuring a grid of color-altered, resized images. Let me know if you'd like more details on any part!
