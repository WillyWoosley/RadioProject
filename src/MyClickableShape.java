/*==============================================================================

name:       MyClickableShape.java

purpose:    A shape that changes it's imaage each time it's clicked.

history:    Sun Dec 06, 2015 08:46:23 (LBM) created.

notes:
                        This program was created by PumaJ
             and is the confidential and proprietary product of PumaJ
        Any unauthorized use, reproduction or transfer is strictly prohibited.

                           COPYRIGHT 2015 BY PumaJ
          (Subject to limited distribution and restricted disclosure only).
                             All rights reserved.

==============================================================================*/
                                       // package ----------------------------//

                                       // imports ----------------------------//
import com.pumaj.PjRectangle;
import java.awt.event.MouseEvent;
                                       // MyClickableShape ===================//
public class MyClickableShape extends PjRectangle
{
                                       // class constants --------------------//
                                       // (none)                              //
                                       // package instance variables ---------//
                                       // (none)                              //
                                       // public instance variables ----------//
                                       // (none)                              //
                                       // protected instance variables -------//
protected String[] imagePaths;         // array of iamge paths                //
protected int      clickCount;         // number of clicks received           //
                                       // private instance variables ---------//
                                       // (none)                              //
/*------------------------------------------------------------------------------

@name       MyClickableShape - default constructor
                                                                              */
                                                                             /**
            Default constructor

@return     An instance of PjInternetRadio if successful.

@history    Sun Dec 06, 2015 08:46:23 (LBM) created.

@notes
                                                                              */
//------------------------------------------------------------------------------
public MyClickableShape()
{
   super();
}
/*------------------------------------------------------------------------------

@name       getImagePaths - get assigned image paths
                                                                              */
                                                                             /**
            Get any assigned image paths.

@return     any assigned image paths; otherwise null.

@history    Sun Dec 06, 2015 08:46:23 (LBM) created.

@notes
                                                                              */
//------------------------------------------------------------------------------
public String[] getImagePaths()
{
   return(imagePaths);
}
/*------------------------------------------------------------------------------

@name       mouseClicked - standard mouseClicked event handler
                                                                              */
                                                                             /**
            This implementation overrides the default of PjThreadSafePanel by
            incrementing the total click count and if image paths have been
            assigned, assigning the next image to this shape.

@return     void

@param      event    mouseClicked event

@history    Sun Dec 06, 2015 08:46:23 (LBM) created.

@notes
                                                                              */
//------------------------------------------------------------------------------
public void mouseClicked(
   MouseEvent  event)
{
                                       // increment the click counter         //
   clickCount++;
   if (imagePaths != null)
   {
                                       // if image paths have been assigned,  //
                                       // assign the next image in sequence   //
      setImage(imagePaths[clickCount % imagePaths.length]);
   }
}
/*------------------------------------------------------------------------------

@name       setImagePaths - set assigned image paths
                                                                              */
                                                                             /**
            Set assigned image paths.

@return     void

@param      imagePaths     array of relative or absolute image paths

@history    Sun Dec 06, 2015 08:46:23 (LBM) created.

@notes
                                                                              */
//------------------------------------------------------------------------------
public void setImagePaths(
   String[] imagePaths)
{
   this.imagePaths = imagePaths;
}
}//====================================// end MyClickableShape ---------------//
