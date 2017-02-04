package com.handy.cruiser.utils;

import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

/**
 * Created by handy on 16/8/2.
 */
public class QAnimationUtils {

    /**
     * 定义从左侧进入的动画效果
     *
     * @return
     */
    public static Animation inFromLeftAnimation() {
        Animation inFromLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromLeft.setDuration(2000);
        inFromLeft.setInterpolator(new AccelerateInterpolator());
        return inFromLeft;
    }

    /**
     * 定义从左侧退出的动画效果
     *
     * @return
     */
    public static Animation outToLeftAnimation() {
        Animation outtoLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        outtoLeft.setDuration(2000);
        outtoLeft.setInterpolator(new AccelerateInterpolator());
        return outtoLeft;
    }

    /**
     * 定义从右侧进入的动画效果
     *
     * @return
     */
    public static Animation inFromRightAnimation() {
        Animation inFromRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromRight.setDuration(2000);
        inFromRight.setInterpolator(new AccelerateInterpolator());
        return inFromRight;
    }

    /**
     * 定义从右侧退出的动画效果
     *
     * @return
     */
    public static Animation outToRightAnimation() {
        Animation outtoRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        outtoRight.setDuration(2000);
        outtoRight.setInterpolator(new AccelerateInterpolator());
        return outtoRight;
    }

    /**
     * 定义从上方进入的动画效果
     *
     * @return
     */
    public static Animation inFromTopAnimation() {
        Animation inFromTop = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromTop.setDuration(2000);
        inFromTop.setInterpolator(new AccelerateInterpolator());
        inFromTop.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        return inFromTop;
    }

    /**
     * 定义从上方退出的动画效果
     *
     * @return
     */
    public static Animation outToTopAnimation(final Animation anim, final View mod) {
        Animation outToTop = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, -1.0f);
        outToTop.setDuration(2000);
        outToTop.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mod.startAnimation(anim);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        outToTop.setInterpolator(new AccelerateInterpolator());
        return outToTop;
    }

    /**
     * 定义从下方进入的动画效果
     *
     * @return
     */
    public static Animation inFromBottomAnimation(final Animation anim, final View mod) {
        Animation inFromBottom = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromBottom.setDuration(2000);
        inFromBottom.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mod.startAnimation(anim);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        inFromBottom.setInterpolator(new AccelerateInterpolator());
        return inFromBottom;
    }

    /**
     * 定义从下方退出的动画效果
     *
     * @return
     */
    public static Animation outToBottomAnimation() {
        Animation outToBottom = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 1.0f);
        outToBottom.setDuration(2000);
        outToBottom.setInterpolator(new AccelerateInterpolator());
        return outToBottom;
    }

    /**
     * 定义从左侧进入的动画效果
     *
     * @return
     */
    public static Animation inFromLeftAnimation2() {
        Animation inFromLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.7f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f);
        inFromLeft.setDuration(2000);
        inFromLeft.setFillAfter(true);
        inFromLeft.setInterpolator(new AccelerateInterpolator());
        return inFromLeft;
    }

    /**
     * 定义从左侧退出的动画效果
     *
     * @return
     */
    public static Animation outToLeftAnimation2() {
        Animation outtoLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f);
        outtoLeft.setDuration(2000);
        outtoLeft.setFillAfter(true);
        outtoLeft.setInterpolator(new AccelerateInterpolator());
        return outtoLeft;
    }

    public static void up2Down(final View mod, final View mod2, final long showTime) {
        mod2.setVisibility(View.VISIBLE);
        mod.startAnimation(QAnimationUtils.outToTopAnimation(QAnimationUtils.inFromTopAnimation(), mod));
        mod2.startAnimation(QAnimationUtils.inFromBottomAnimation(QAnimationUtils.outToBottomAnimation(), mod2));

        Handler mHandler = new Handler();

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mod2.setVisibility(View.INVISIBLE);
            }
        }, 5000);

    }

//    public static void down2Up(final View mod, final View mod2, final long showTime){
//        Handler mHandler = new Handler();
//        mod.startAnimation(QAnimationUtils.outToBottomAnimation());
//        if (mod2.getVisibility()==View.GONE){
//            mod2.setVisibility(View.VISIBLE);
//        }
//        mod2.startAnimation(QAnimationUtils.inFromBottomAnimation());
//        if (showTime!=0) {
//            mHandler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    mod.setVisibility(View.INVISIBLE);
//                }
//            }, 2000);
//        }
//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if (showTime!=0) {
//                    mod.setVisibility(View.VISIBLE);
//                }
//                mod.startAnimation(QAnimationUtils.outToBottomAnimation());
//                mod2.startAnimation(QAnimationUtils.outToBottomAnimation());
//            }
//        }, 2000+showTime);
//
//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mod2.setVisibility(View.GONE);
//            }
//        }, 4000+showTime);
//    }


    public static void sh(final View mod) {
        _sh(mod);
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mod.setVisibility(View.GONE);
            }
        }, 3000);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mod.setVisibility(View.VISIBLE);
                sh_(mod);
            }
        }, 4000);
    }

    public static void _sh(View mod) {
        Animation alphaAnimation = new AlphaAnimation(1, 0);

        alphaAnimation.setDuration(3000);//设置动画持续时间为3秒

        alphaAnimation.setFillAfter(false);//设置动画结束后保持当前的位置（即不返回到动画开始前的位置）

        mod.startAnimation(alphaAnimation);
    }

    public static void sh_(View mod) {
        Animation alphaAnimation = new AlphaAnimation(0, 1);

        alphaAnimation.setDuration(3000);//设置动画持续时间为3秒

        alphaAnimation.setFillAfter(false);//设置动画结束后保持当前的位置（即不返回到动画开始前的位置）

        mod.startAnimation(alphaAnimation);
    }

    public static void di(final View mod) {

        _di(mod);
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mod.setVisibility(View.GONE);
            }
        }, 3000);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mod.setVisibility(View.VISIBLE);
                di_(mod);
            }
        }, 4000);
    }

    public static void _di(View mod) {
        Animation rotateAnimation = new RotateAnimation(0, 90);

        rotateAnimation.setDuration(3000);//设置动画持续时间为3秒

        rotateAnimation.setFillAfter(false);//设置动画结束后保持当前的位置（即不返回到动画开始前的位置）

        mod.startAnimation(rotateAnimation);
    }

    public static void di_(View mod) {
        Animation rotateAnimation = new RotateAnimation(90, 0);

        rotateAnimation.setDuration(3000);//设置动画持续时间为3秒

        rotateAnimation.setFillAfter(false);//设置动画结束后保持当前的位置（即不返回到动画开始前的位置）

        mod.startAnimation(rotateAnimation);
    }

    public static void ss(final View mod) {
        Handler mHandler = new Handler();
        _ss(mod);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mod.setVisibility(View.GONE);
            }
        }, 3000);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mod.setVisibility(View.VISIBLE);
                ss_(mod);
            }
        }, 4000);
    }

    public static void _ss(View mod) {
        Animation scaleAnimation = new ScaleAnimation(1.0f, 0, 1.0f, 1.0f);
        scaleAnimation.setDuration(3000);//设置动画持续时间为3秒
        scaleAnimation.setFillAfter(false);//设置动画结束后保持当前的位置（即不返回到动画开始前的位置）
//        scaleAnimation.setRepeatCount(33;
        mod.startAnimation(scaleAnimation);
    }

    public static void ss_(View mod) {
        Animation scaleAnimation = new ScaleAnimation(0, 1.0f, 1.0f, 1.0f);
        scaleAnimation.setDuration(3000);//设置动画持续时间为3秒
        scaleAnimation.setFillAfter(false);//设置动画结束后保持当前的位置（即不返回到动画开始前的位置）
//        scaleAnimation.setRepeatCount(33;
        mod.startAnimation(scaleAnimation);
    }
}