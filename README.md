# RahmenView
RahmenView looks like a photo frame.You can use it to show your AD or Photos.

![](https://github.com/KernHu/RahmenView/raw/master/screenshot/2018061501.gif)  ![](https://github.com/KernHu/RahmenView/raw/master/screenshot/2018061501.png)  

## How to use
### 1.Add the RahmenView to the layout.xml file where you want to display the list;

  <cn.walkpast.rahmen.RahmenView
        android:id="@+id/rahmen_view_ad"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_gravity="center"
        app:rhv_anim="true"
        app:rhv_backgroud="@drawable/bg_rahmen_2"
        app:rhv_duration="1000"
        app:rhv_image_height="@dimen/rhv_sp_height"
        app:rhv_image_rotation="-7"
        app:rhv_image_width="@dimen/rhv_sp_width"
        app:rhv_image_x="@dimen/rhv_sp_left"
        app:rhv_image_y="@dimen/rhv_sp_top"/>

    <!--    app:rhv_image="@drawable/sample_plot_3" -->
    <!--    app:rhv_backgroud="@drawable/bg_rahmen_2"-->
    <!--    app:rhv_foreground="@drawable/fg_rahmen_1" -->

### 2.If you want use the event;

 mRahmenView.setOnRahmenListener(mOnRahmenListener);
  OnRahmenListener mOnRahmenListener = new OnRahmenListener() {
        @Override
        public void onClick(View view) {
            super.onClick(view);
         
        }

        @Override
        public void onLongClick(View view) {
            super.onLongClick(view);
           
        }
    };

### 3.You also can set ....;

  	mRahmenView.setRahmenImage();
        mRahmenView.getRahmenImageHeight()
        mRahmenView.setRahmenImageWidth();
        mRahmenView.getRahmenImageY()
        mRahmenView.setRahmenImageY();
        mRahmenView.setRahmenImageRotation();
        mRahmenView.setRahmenForeground();
        mRahmenView.setRahmenBackgroud();


## Add RahmenView to your project
### Step 1. Add the JitPack repository to your build file; Add it in your root build.gradle at the end of repositories:

allprojects {
        repositories {
        ...
        maven { url 'https://jitpack.io' }
        }
        }
## Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.KernHu:RahmenView:v1.0'
	}
