/*==============================================================================

name:       PjInternetRadio.java

purpose:    An Internet Radio using the PumaJ Framework.
            
history:    Sun Nov 27, 2011 08:46:23 (LBM) created.

notes:
                        This program was created by PumaJ
             and is the confidential and proprietary product of PumaJ
        Any unauthorized use, reproduction or transfer is strictly prohibited.

                           COPYRIGHT 2011 BY PumaJ
          (Subject to limited distribution and restricted disclosure only).
                             All rights reserved.

==============================================================================*/
                                       // package ----------------------------//
 
                                       // imports ----------------------------//
import com.giavaneers.gui.elements.embedded.GvIMediaPlayer;
import com.giavaneers.gui.elements.embedded.GvVLCMediaPlayer;
import com.pumaj.PjApplication;
                                       // PjInternetRadio ====================//
public class PjInternetRadio extends PjApplication
{
                                       // class constants --------------------//
protected static final String[] kRELATIVE_IMAGE_PATHS =
{
   "images/fish.jpg", "images/dog.jpg", "images/bird.jpg"
};
                                       // package instance variables ---------//
                                       // (none)                              //
                                       // public instance variables ----------//
                                       // (none)                              //
                                       // protected instance variables -------//
protected GvIMediaPlayer mediaPlayer;  // media player                        //
                                       // private instance variables ---------//
                                       // (none)                              //
/*------------------------------------------------------------------------------

@name       PjInternetRadio - default constructor
                                                                              */
                                                                             /**
            Default constructor

@return     An instance of PjInternetRadio if successful.

@history    Sun Nov 27, 2011 08:46:23 (LBM) created.

@notes
                                                                              */
//------------------------------------------------------------------------------
public PjInternetRadio()
{
}
/*------------------------------------------------------------------------------

@name       buildGUI - build the radio gui
                                                                              */
                                                                             /**
            Build the radio graphical user interface.

@return     void

@history    Sun Dec 06, 2015 08:46:23 (LBM) created.

@notes
                                                                              */
//------------------------------------------------------------------------------
protected void buildGUI()
{
                                       // assign this app properties          //
   setLayout(null);
   setVisible(true);
   setWidth(940);
   setHeight(720);
                                       // add a clickable shape 200x200       //
   MyClickableShape myShape = new MyClickableShape();
   myShape.setWidth(200);
   myShape.setHeight(200);
   myShape.setLocation(100, 100);
                                       // assign image paths to the shape     //
   myShape.setImagePaths(kRELATIVE_IMAGE_PATHS);

                                       // and add it to this app              //
   add(myShape);
}
/*------------------------------------------------------------------------------

@name       getMediaPlayer - get media player
                                                                              */
                                                                             /**
            Get media player instance.

@return     media player instance.

@history    Sun Nov 27, 2011 08:46:23 (LBM) created.

@notes
                                                                              */
//------------------------------------------------------------------------------
public GvIMediaPlayer getMediaPlayer()
{
   if (mediaPlayer == null)
   {
      mediaPlayer = new GvVLCMediaPlayer();
   }
   
   return(mediaPlayer);
}
/*------------------------------------------------------------------------------

@name       main - project main routine
                                                                              */
                                                                             /**
            Project main routine

@return     void.

@param      args  command line arguments

@history    Sun Nov 27, 2011 08:46:23 (LBM) created.

@notes
                                                                              */
//------------------------------------------------------------------------------
public static void main(
   String   args[])
{
   try
   {
      System.out.println(
         "Java VM running " + System.getProperty("java.version") 
            + ", " + System.getProperty("os.arch") +  ", " 
            + System.getProperty("sun.arch.data.model") + " bit");
      
      PjInternetRadio myRadio = new PjInternetRadio();
      myRadio.buildGUI();

      String[] mediaPaths =
      {
         "http://66.225.205.169/ss3.mp3.56"
         //"http://streams.kqed.org/kqedradio",//kqed
         //"http://stream1.evasionfm.com/Chante_France",//chante-france
      };

      if (true)
      {
         GvIMediaPlayer player = myRadio.getMediaPlayer();
                                       // start the player                    //
         int pathIdx = Integer.parseInt(args[0]);
         player.setURI(mediaPaths[pathIdx]);
      }
      else
      {
                                       // multiple stations at once           //
         GvIMediaPlayer player1 = new GvVLCMediaPlayer();
         player1.setURI(mediaPaths[0]);

         com.pumaj.PjUtils.sleep(5000);

         GvIMediaPlayer player2 = new GvVLCMediaPlayer();
         player2.setURI(mediaPaths[1]);
      }
   }
   catch(Exception e)
   {
      e.printStackTrace();
   }
}
}//====================================// end PjInternetRadio ----------------//
