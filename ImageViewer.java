/**
 * @author A K M NAHARUL HAYAT
 * @version 
 */
public class ImageViewer
{    
    //**************FIELDS*******************
    private ImageViewerGUI gui;      //*the Graphical User Interface
    private Album album;             //*represents the collection of image
    private Image currentImage;      //*the current image that is displayed
    private int imageIndex;          //*refers to the index number of the image being displayed    
    private int imageViewCounter;    //*counts the number of images viewed
    private int imageWidthSummation; //*sums up the widths of the images viewed
    private int maxWidth;            //*holds the width value, of the image with the maximum width in the album
    private int maxHeight;           //*holds the height value, of the image with the maximum height in the album

    //**************CONSTRUCTOR*******************
    /**
     * Create an ImageViewer and display its GUI on screen.
     * Creates an album.
     * Instantiates the fields.
     * calls a method to compute the maximum image height and width and sets up the gui according to that.
     * calls methods to display the first image and also it's name and size.
     */
    public ImageViewer()
    {
        imageIndex = 0;
        maxWidth = 0;
        maxHeight = 0;
        gui = new ImageViewerGUI(this);
        album = new Album("images");
        currentImage = album.getImage(imageIndex);
        computeMaxWidth();
        computeMaxHeight();
        gui.setImageSize(maxWidth, maxHeight);
        displayImage();
        displayName();
        showDimension();
        imageViewCounter = 1;
        imageWidthSummation = currentImage.getWidth();
        
    }
    
    //**************METHODS*******************
    /**
     * iterates through all the images in the album and stores the width value of the image with the largest width in a field
     * to enable the gui to be initialised according to the size of the largest image
     */
    public void computeMaxWidth()
    {
        Image imageForComputation1;
     for(int i=0; i<album.numberOfImages(); i++)
        {
             imageForComputation1 = album.getImage(i) ;
             if(imageForComputation1.getWidth()>maxWidth)
             {
                 maxWidth = imageForComputation1.getWidth();
             }
        }
    }
    /**
     * iterates though all the images in the album 
     * and stores the height value of the image with the largest width in the maxHeight variable
     * to enable the gui to be initialised according to the size of the largest image
     */
    public void computeMaxHeight()
    {
        Image imageForComputation2;
        for(int i=0; i<album.numberOfImages(); i++)
        {
             imageForComputation2 = album.getImage(i) ;
             if(imageForComputation2.getHeight()>maxHeight)
             {
                 maxHeight = imageForComputation2.getHeight();
             }
        }
    }
   
    /**
     * displays the image from the album
     */
    public void displayImage()
    {
       currentImage = album.getImage(imageIndex);
       gui.showImage(currentImage);
    }
    /**
     * displays the name of the image in the gui
     */
    public void displayName()
    {
        gui.showName(currentImage.getName());
    }
    /**
     * displays the dimension (Height x Width) of the image in the gui
     */
    public void showDimension()
    {
        gui.showStatus("Height = " + Integer.toString(currentImage.getHeight()) + "  Width = " + Integer.toString(currentImage.getWidth()));
    }

    /**
     * shows the next image in the album. If the program is at the last image of the album, then jumps to the first
     */
    public void nextImage()
    { 
        imageIndex = imageIndex + 1;
        if(imageIndex == album.numberOfImages())
        {
            imageIndex = 0;
        }
        displayImage();
        displayName();
        showDimension();
        imageViewCounter = imageViewCounter + 1;
        imageWidthSummation = imageWidthSummation + currentImage.getWidth();
    }

    /**
     * shows the previous image in the album. If the program is at the first image of the album, then jumps to the last
     */
    public void previousImage()
    {
        if(imageIndex == 0)
        {
            imageIndex = (album.numberOfImages() - 1);
        }
        else
        {
            imageIndex = imageIndex - 1;
        }
        displayImage();
        displayName();
        showDimension();
        imageViewCounter = imageViewCounter + 1;
        imageWidthSummation = imageWidthSummation + currentImage.getWidth();
    }

    /**
     * applies the fish eye effect to a picture
     */
    public void fishEye()
    {
        currentImage.fishEye();
        displayImage();
        displayName();
        showDimension();
    }
    
   /**
    * this method returns the number of images viewed so far. (Viewing the same image twice counts as 2 views)
    */
   public int getNumberOfImagesViewed()
   {
       int counter = imageViewCounter;
       return counter;
   }
  /**
   *  returns the average width of the images viewed so far
   */
  public int averageImageWidth()
  {
      int averageWidth;
      averageWidth = (imageWidthSummation/imageViewCounter);
      return averageWidth;
      
  }
   

}
