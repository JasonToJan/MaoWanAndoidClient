package mao.com.mao_wanandroid_client.base.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import mao.com.mao_wanandroid_client.base.BaseView;
import mao.com.mao_wanandroid_client.base.presenter.AbstractBasePresenter;
import mao.com.mao_wanandroid_client.model.home.HomeArticleData;

/**
 * @author maoqitian
 * @Description MVP DialogFragment 基类
 * @Time 2018/12/14 0014 22:47
 */
public abstract class BaseDialogFragment<T extends AbstractBasePresenter> extends SimpleDialogFragment implements BaseView {

    //Presenter 对象注入
    @Inject
    protected T mPresenter;

    /*@Override
    public void onAttach(Activity activity) {
        AndroidSupportInjection.inject(this);
        super.onAttach(activity);

    }*/

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(mPresenter != null){
            Log.e("毛麒添","BaseDialogFragment  mPresenter 不为空" + mPresenter.getClass());
            mPresenter.attachView(this);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(mPresenter != null){
            mPresenter.detachView();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if(mPresenter != null){
            mPresenter = null;
        }
    }

    @Override
    public void showNormal() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showReload() {

    }

    @Override
    public void showErrorMsg(String errorMsg) {

    }

    @Override
    public void useNightMode(boolean isNightMode) {

    }

    @Override
    public void showLoginView() {

    }

    @Override
    public void showLogoutView() {

    }

    @Override
    public void showCollectSuccess() {

    }

    @Override
    public void showCancelCollectSuccess() {

    }

    @Override
    public void showToast(String message) {

    }

    @Override
    public void showSnackBar(String message) {

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }


    @Override
    public void reload() {

    }

    @Override
    public void showAddArticleCollectStatus(int position, HomeArticleData homeArticleData, String msg) {

    }

    @Override
    public void showCancelArticleCollectStatus(int position, HomeArticleData homeArticleData, String msg) {

    }
}
