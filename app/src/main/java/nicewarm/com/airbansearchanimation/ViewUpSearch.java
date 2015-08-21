package nicewarm.com.airbansearchanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by sreay on 15/8/20.
 */
public class ViewUpSearch extends LinearLayout {


    private View width;
    private View round;
    private float scale;
    private View circle;

    public ViewUpSearch(Context context) {
        super(context);
        initView(context);
    }

    public ViewUpSearch(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.view_choice_up_search, this, true);
        width = findViewById(R.id.width);
        round = findViewById(R.id.round);
        circle = findViewById(R.id.circle);
    }


    public void updateShow(boolean isExpand) {
        double serchWid = round.getWidth() / 1.0;
        double wid = width.getWidth() / 1.0;
        double fenshu = wid / serchWid;
        scale = (float) fenshu;

        if (isExpand) {
            expandSearch();
        } else {
            closeSearch();
        }
    }

    private void expandSearch() {

        circle.setVisibility(View.VISIBLE);
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(circle, "alpha", 1f, 0f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(round, "alpha", 0f, 1f);
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(round, "scaleX", scale, 1f);
        round.setPivotX(0);
        AnimatorSet animSet2= new AnimatorSet();
        animSet2.play(anim1).with(anim2).with(anim3);
        animSet2.setDuration(100);
        animSet2.start();

    }

    private void closeSearch() {
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(round, "scaleX", 1f, scale);
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(circle, "alpha", 0f, 1f);
        circle.setVisibility(View.VISIBLE);
        ObjectAnimator anim4 = ObjectAnimator.ofFloat(round, "alpha", 1f, 0f);
        round.setPivotX(0);
        round.setPivotY(round.getHeight() / 2);
        AnimatorSet animSet1 = new AnimatorSet();
        animSet1.play(anim2).with(anim3).with(anim4);
        animSet1.setDuration(100);
        animSet1.start();
    }

}
