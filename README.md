# RahmenView
RahmenView looks like a photo frame.You can use it to show your AD or Photos.It's base on PercentFrameLayout, so it ealily to fit any different resolution screens.It also can use Glide to load online picture.

RahmenViev像一个相框模版，你可以用来展示广告图片或者照片，它基于百分比布局，因为可以很好的适配一些不同分辨率的屏幕。它还可以通过Glide来加载网络图片。

![](https://github.com/KernHu/RahmenView/raw/master/screenshot/10010.gif)  ![](https://github.com/KernHu/RahmenView/raw/master/screenshot/10011.gif)  

##  I: How to use RahmenView.
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
	

### 2.How to use the event;

      mRahmenView.setOnRahmenListener(mOnRahmenListener);
      OnRahmenListener mOnRahmenListener = new OnRahmenListener() {
        @Override
    
        @Override
        public void onLongClick(View view) {
            super.onLongClick(view);
           
        }
	public void onClick(View view) {
            super.onClick(view);
         
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
	
	//load image
	 Glide.with(this)
                .load(url)
                .placeholder(R.drawable.sample_plot_1)
                .into(mRahmenView.getImageView());


## II: Add RahmenView to your project

### Step 1. Add the JitPack repository to your build file; Add it in your root build.gradle at the end of repositories:

	allprojects {
        repositories {
        ...
        maven { url 'https://jitpack.io' }
        }
        }
	
### Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.KernHu:RahmenView:v1.0'
	}
	
## III: Contact me

Email: sky580@126.com  
I‘m kern....







