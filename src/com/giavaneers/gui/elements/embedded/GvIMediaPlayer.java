/*=============================================================================

name:       GvIMediaPlayer.java

purpose:    Media Player Interface

history:    Thu Apr 28, 2011 10:30:00 (Giavaneers - LBM) created

notes:
                     This program was created by Giavaneers
            and is the confidential and proprietary product of Giavaneers.
         Any unauthorized use, reproduction or transfer is strictly prohibited.

                        COPYRIGHT 2011 BY GIAVANEERS, INC.
         (Subject to limited distribution and restricted disclosure only).
                              All rights reserved.

============================================================================= */
                                       // package --------------------------- //
package com.giavaneers.gui.elements.embedded;
                                       // imports --------------------------- //
import com.giavaneers.properties.GvProperties;
import com.giavaneers.properties.datastore.GvIAbstractPropertiesOwner;
import java.net.URI;
import java.net.URISyntaxException;
                                       // GvIMediaPlayer =====================//
public interface GvIMediaPlayer extends GvIAbstractPropertiesOwner
{
                                       // class constants ------------------- //
                                       // properties                          //
                                       // define the namespace explicitly     //
public static final String kNAMESPACE =
   GvIMediaPlayer.class.getName();
   
public static final String kPROPERTY_BACKWARD =
   GvProperties.makePropertyKey(
      GvProperties.makePropertyAttributes(
         GvProperties.kATTRIB_NAMESPACE,     kNAMESPACE, 
         GvProperties.kATTRIB_PROPERTY_NAME, "backward",
         GvProperties.kATTRIB_DISPLAY_NAME,  "Backward"));
   
public static final String kPROPERTY_END_OF_SUBITEMS =
   GvProperties.makePropertyKey(
      GvProperties.makePropertyAttributes(
         GvProperties.kATTRIB_NAMESPACE,     kNAMESPACE, 
         GvProperties.kATTRIB_PROPERTY_NAME, "endOfSubitems",
         GvProperties.kATTRIB_DISPLAY_NAME,  "End of SubItems"));
   
public static final String kPROPERTY_FORWARD =
   GvProperties.makePropertyKey(
      GvProperties.makePropertyAttributes(
         GvProperties.kATTRIB_NAMESPACE,     kNAMESPACE, 
         GvProperties.kATTRIB_PROPERTY_NAME, "forward",
         GvProperties.kATTRIB_DISPLAY_NAME,  "Forward"));
   
public static final String kPROPERTY_LENGTH_CHANGED =
   GvProperties.makePropertyKey(
      GvProperties.makePropertyAttributes(
         GvProperties.kATTRIB_NAMESPACE,     kNAMESPACE, 
         GvProperties.kATTRIB_PROPERTY_NAME, "lengthChanged",
         GvProperties.kATTRIB_DISPLAY_NAME,  "Length Changed"));
         
public static final String kPROPERTY_MEDIA_CHANGED =
   GvProperties.makePropertyKey(
      GvProperties.makePropertyAttributes(
         GvProperties.kATTRIB_NAMESPACE,     kNAMESPACE, 
         GvProperties.kATTRIB_PROPERTY_NAME, "mediaChanged",
         GvProperties.kATTRIB_DISPLAY_NAME,  "Media Changed"));
         
public static final String kPROPERTY_MEDIA_DURATION_CHANGED =
   GvProperties.makePropertyKey(
      GvProperties.makePropertyAttributes(
         GvProperties.kATTRIB_NAMESPACE,     kNAMESPACE, 
         GvProperties.kATTRIB_PROPERTY_NAME, "mediaDurationChanged",
         GvProperties.kATTRIB_DISPLAY_NAME,  "Media Duration Changed"));
   
public static final String kPROPERTY_MEDIA_FREED =
   GvProperties.makePropertyKey(
      GvProperties.makePropertyAttributes(
         GvProperties.kATTRIB_NAMESPACE,     kNAMESPACE, 
         GvProperties.kATTRIB_PROPERTY_NAME, "mediaFreed",
         GvProperties.kATTRIB_DISPLAY_NAME,  "Media Freed"));
   
public static final String kPROPERTY_MEDIA_META_CHANGED =
   GvProperties.makePropertyKey(
      GvProperties.makePropertyAttributes(
         GvProperties.kATTRIB_NAMESPACE,     kNAMESPACE, 
         GvProperties.kATTRIB_PROPERTY_NAME, "mediaMetaChanged",
         GvProperties.kATTRIB_DISPLAY_NAME,  "Media Meta Changed"));
         
public static final String kPROPERTY_MEDIA_PARSED_CHANGED =
   GvProperties.makePropertyKey(
      GvProperties.makePropertyAttributes(
         GvProperties.kATTRIB_NAMESPACE,     kNAMESPACE, 
         GvProperties.kATTRIB_PROPERTY_NAME, "parsedChanged",
         GvProperties.kATTRIB_DISPLAY_NAME,  "Parsed Changed"));
   
public static final String kPROPERTY_MEDIA_STATE_CHANGED =
   GvProperties.makePropertyKey(
      GvProperties.makePropertyAttributes(
         GvProperties.kATTRIB_NAMESPACE,     kNAMESPACE, 
         GvProperties.kATTRIB_PROPERTY_NAME, "mediaStateChanged",
         GvProperties.kATTRIB_DISPLAY_NAME,  "Media State Changed"));
         
public static final String kPROPERTY_NEW_MEDIA =
   GvProperties.makePropertyKey(
      GvProperties.makePropertyAttributes(
         GvProperties.kATTRIB_NAMESPACE,     kNAMESPACE, 
         GvProperties.kATTRIB_PROPERTY_NAME, "newMedia",
         GvProperties.kATTRIB_DISPLAY_NAME,  "New Media"));
         
public static final String kPROPERTY_NEW_POSITION =
   GvProperties.makePropertyKey(
      GvProperties.makePropertyAttributes(
         GvProperties.kATTRIB_NAMESPACE,     kNAMESPACE, 
         GvProperties.kATTRIB_PROPERTY_NAME, "newPosition",
         GvProperties.kATTRIB_DISPLAY_NAME,  "New Position"));
         
public static final String kPROPERTY_PAUSABLE_CHANGED =
   GvProperties.makePropertyKey(
      GvProperties.makePropertyAttributes(
         GvProperties.kATTRIB_NAMESPACE,     kNAMESPACE, 
         GvProperties.kATTRIB_PROPERTY_NAME, "pausableChanged",
         GvProperties.kATTRIB_DISPLAY_NAME,  "Pausable Changed"));
         
public static final String kPROPERTY_SEEKABLE_CHANGED =
   GvProperties.makePropertyKey(
      GvProperties.makePropertyAttributes(
         GvProperties.kATTRIB_NAMESPACE,     kNAMESPACE, 
         GvProperties.kATTRIB_PROPERTY_NAME, "seekableChanged",
         GvProperties.kATTRIB_DISPLAY_NAME,  "Seekable Changed"));
         
public static final String kPROPERTY_SNAPSHOT_TAKEN =
   GvProperties.makePropertyKey(
      GvProperties.makePropertyAttributes(
         GvProperties.kATTRIB_NAMESPACE,     kNAMESPACE, 
         GvProperties.kATTRIB_PROPERTY_NAME, "snapshotTaken",
         GvProperties.kATTRIB_DISPLAY_NAME,  "Snapshot Taken"));
         
public static final String kPROPERTY_SUBITEM_ADDED =
   GvProperties.makePropertyKey(
      GvProperties.makePropertyAttributes(
         GvProperties.kATTRIB_NAMESPACE,     kNAMESPACE, 
         GvProperties.kATTRIB_PROPERTY_NAME, "subItemAdded",
         GvProperties.kATTRIB_DISPLAY_NAME,  "SubItem Added"));
         
public static final String kPROPERTY_SUBITEM_FINISHED =
   GvProperties.makePropertyKey(
      GvProperties.makePropertyAttributes(
         GvProperties.kATTRIB_NAMESPACE,     kNAMESPACE, 
         GvProperties.kATTRIB_PROPERTY_NAME, "subItemFinished",
         GvProperties.kATTRIB_DISPLAY_NAME,  "SubItem Finished"));
         
public static final String kPROPERTY_SUBITEM_PLAYED =
   GvProperties.makePropertyKey(
      GvProperties.makePropertyAttributes(
         GvProperties.kATTRIB_NAMESPACE,     kNAMESPACE, 
         GvProperties.kATTRIB_PROPERTY_NAME, "subItemPlayed",
         GvProperties.kATTRIB_DISPLAY_NAME,  "SubItem Played"));
         
public static final String kPROPERTY_TIME_CHANGED =
   GvProperties.makePropertyKey(
      GvProperties.makePropertyAttributes(
         GvProperties.kATTRIB_NAMESPACE,     kNAMESPACE, 
         GvProperties.kATTRIB_PROPERTY_NAME, "timeChanged",
         GvProperties.kATTRIB_DISPLAY_NAME,  "Time Changed"));
         
public static final String kPROPERTY_TITLE =
   GvProperties.makePropertyKey(
      GvProperties.makePropertyAttributes(
         GvProperties.kATTRIB_NAMESPACE,     kNAMESPACE, 
         GvProperties.kATTRIB_PROPERTY_NAME, "title",
         GvProperties.kATTRIB_DISPLAY_NAME,  "Title"));
         
public static final String kPROPERTY_TITLE_CHANGED =
   GvProperties.makePropertyKey(
      GvProperties.makePropertyAttributes(
         GvProperties.kATTRIB_NAMESPACE,     kNAMESPACE, 
         GvProperties.kATTRIB_PROPERTY_NAME, "titleChanged",
         GvProperties.kATTRIB_DISPLAY_NAME,  "Title Changed"));
         
public static final String kPROPERTY_TITLE_VIDEO_OUT_AVAILABLE =
   GvProperties.makePropertyKey(
      GvProperties.makePropertyAttributes(
         GvProperties.kATTRIB_NAMESPACE,     kNAMESPACE, 
         GvProperties.kATTRIB_PROPERTY_NAME, "videoOutAvailable",
         GvProperties.kATTRIB_DISPLAY_NAME,  "Video Output Available"));
         
public static final String kPROPERTY_URI =
   GvProperties.makePropertyKey(
      GvProperties.makePropertyAttributes(
         GvProperties.kATTRIB_NAMESPACE,     kNAMESPACE, 
         GvProperties.kATTRIB_PROPERTY_NAME, "uri",
         GvProperties.kATTRIB_DISPLAY_NAME,  "URI"));
         
                                       // well-known property values          //

public static final int kPROPERTY_STATE_CHANGED_EVENT_UNKNOWN = -1;
public static final int kPROPERTY_STATE_CHANGED_EVENT_INITIAL = 0;
public static final int kPROPERTY_STATE_CHANGED_EVENT_PAUSED  = 1;
public static final int kPROPERTY_STATE_CHANGED_EVENT_PLAYING = 2;
public static final int kPROPERTY_STATE_CHANGED_EVENT_READY   = 3;

public static final int kPROPERTY_STATE_OPENING  = 
                                           GvProperties.kPROPERTY_STATE_MAX + 1;
public static final int kPROPERTY_STATE_BUFFERING= kPROPERTY_STATE_OPENING  + 1;
public static final int kPROPERTY_STATE_PLAYING  = kPROPERTY_STATE_BUFFERING+ 1;
public static final int kPROPERTY_STATE_PAUSED   = kPROPERTY_STATE_PLAYING  + 1;
public static final int kPROPERTY_STATE_STOPPING = kPROPERTY_STATE_PAUSED   + 1;
public static final int kPROPERTY_STATE_ENDED    = kPROPERTY_STATE_STOPPING + 1;
public static final int kPROPERTY_STATE_ERROR    = kPROPERTY_STATE_ENDED    + 1;
         
                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables ------ //
                                       // (none)                              //
                                       // private instance variables -------- //
                                       // (none)                              //

/*------------------------------------------------------------------------------

@name       getAudioVolume - get audio volume
                                                                              */
                                                                             /**
            Get audio volume.

@return     audio volume value between 0.0 and 1.0.

@history    Fri Nov 12, 2010 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public double getAudioVolume();

/*------------------------------------------------------------------------------

@name       getLoop - get whether is playing continuous loop
                                                                              */
                                                                             /**
            Get whether is playing continuous loop.

@return     true iff is playing continuous loop

@history    Fri Nov 12, 2010 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public boolean getLoop();

/*------------------------------------------------------------------------------

@name       getLength - get maximum progress value
                                                                              */
                                                                             /**
            Get maximum progress value.

@return     maximum progress value

@history    Fri Nov 12, 2010 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public long getLength();

/*------------------------------------------------------------------------------

@name       getPaused - get whether is paused
                                                                              */
                                                                             /**
            Get whether is paused.

@return     true iff is paused

@history    Fri Nov 12, 2010 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public boolean getPaused();

/*------------------------------------------------------------------------------

@name       getPlaying - get whether is playing
                                                                              */
                                                                             /**
            Get whether is playing.

@return     true iff is playing

@history    Fri Nov 12, 2010 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public boolean getPlaying();

/*------------------------------------------------------------------------------

@name       getProgress - get progress
                                                                              */
                                                                             /**
            Get progress.

@return     progress

@history    Fri Nov 12, 2010 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public double getProgress();

/*------------------------------------------------------------------------------

@name       getTitle - get title
                                                                              */
                                                                             /**
            Get title.

@return     title

@history    Fri Nov 12, 2010 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public String getTitle();

/*------------------------------------------------------------------------------

@name       getURI - get uri
                                                                              */
                                                                             /**
            Get uri.

@return     uri

@history    Fri Nov 12, 2010 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public String getURI();

/*------------------------------------------------------------------------------

@name       seek - seek to specified position
                                                                              */
                                                                             /**
            Seek to specified position.

@return     void

@param      position    specified position, in msecs

@history    Fri Nov 12, 2010 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public void seek(
   long  position);
   
/*------------------------------------------------------------------------------

@name       setAudioVolume - set audio volume
                                                                              */
                                                                             /**
            Set audio volume.

@return     void

@param      audioVolume    audio volume value between 0.0 and 1.0.

@history    Fri Nov 12, 2010 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public void setAudioVolume(
   double audioVolume);
   
/*------------------------------------------------------------------------------

@name       setFullscreen - set fullscreen
                                                                              */
                                                                             /**
            Set fullscreen.

@return     void

@param      bFullScreen    true iff to be set fullscreen

@history    Mon Oct 24, 2011 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public void  setFullscreen(
   boolean   bFullScreen);
   
/*------------------------------------------------------------------------------

@name       setLoop - set whether is playing continuous loop
                                                                              */
                                                                             /**
            Set whether is playing continuous loop.

@return     void

@param      bPlaying    true iff is playing continuous loop

@history    Fri Nov 12, 2010 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public void setLoop(
   boolean bLoop);
   
/*------------------------------------------------------------------------------

@name       setMarqueeSize - set marquee size
                                                                              */
                                                                             /**
            Set marquee size.

@return     void

@param      size     marquee size

@history    Thu Apr 28, 2011 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public void setMarqueeSize(
   int size);
   
/*------------------------------------------------------------------------------

@name       setMute - set whether is audio volume is muted
                                                                              */
                                                                             /**
            Set whether is audio volume is muted.

@return     void

@param      bMute    true iff is audio volume is muted; otherwise, restore
                     existing volume setting

@history    Fri Nov 12, 2010 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public void setMute(
   boolean bMute);

/*------------------------------------------------------------------------------

@name       setPaused - set whether is paused
                                                                              */
                                                                             /**
            Set whether is paused.

@return     void

@param      paused      true iff is paused

@history    Fri Nov 12, 2010 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public void setPaused(
   boolean bPaused);
   
/*------------------------------------------------------------------------------

@name       setPlaying - set whether is playing
                                                                              */
                                                                             /**
            Set whether is playing.

@return     void

@param      bPlaying    true iff is playing

@history    Fri Nov 12, 2010 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public void setPlaying(
   boolean bPlaying);

/*------------------------------------------------------------------------------

@name       setProgress - set progress
                                                                              */
                                                                             /**
            Set progress.

@return     void

@param      progress    progress

@history    Fri Nov 12, 2010 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public void setProgress(
   double progress);

/*------------------------------------------------------------------------------

@name       setTitle - set title
                                                                              */
                                                                             /**
            Set title.

@return     void

@param      title    title

@history    Fri Nov 12, 2010 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public void setTitle(
   String title);

/*------------------------------------------------------------------------------

@name       setURI - set uri
                                                                              */
                                                                             /**
            Set uri and start the player playing.
            
            For example,
            
            <pre>
            ...
            GvIMediaPlayer  player    = getMediaPlayer();
            String          mediaPath = "http://streams.kqed.org/kqedradio";
   
            try
            {
               player.setURI(mediaPath);
            }
            catch(Exception e)
            {
               e.printStackTrace();
            }
            </pre>

@return     void

@param      uri      uri

@history    Fri Nov 12, 2010 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public void setURI(
   String uri)
   throws URISyntaxException;

/*------------------------------------------------------------------------------

@name       setVisible - set visible, either true or false
                                                                              */
                                                                             /**
            Set visible, either true or false.

@return     void

@param      bVisible    true iff visible

@history    Tue Apr 26, 2011 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public void setVisible(
   boolean bVisible)
   throws  Exception;
   
}//====================================// interface GvIMediaPlayer -----------//


