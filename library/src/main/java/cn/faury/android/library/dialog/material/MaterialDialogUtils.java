package cn.faury.android.library.dialog.material;

import android.content.Context;
import android.support.annotation.NonNull;

import com.afollestad.materialdialogs.MaterialDialog;

/**
 * 常用对话框工具
 */

public class MaterialDialogUtils {

    /**
     * 获取警告框
     *
     * @param context 上下文，没有传入时从SskSdk中读取当前的上下文
     * @param title   标题，为空时不显示标题
     * @param content 警告内容
     * @param btnText 按钮文字，默认为“确认”
     * @param btnCb   点击确认按钮回调
     * @return 对话框对象
     */
    public static MaterialDialog alert(@NonNull Context context, String title, @NonNull String content, String btnText, MaterialDialog.SingleButtonCallback btnCb) {
        MaterialDialog.Builder builder = new MaterialDialog.Builder(context);
        if (isNotEmpty(title)) {
            builder.title(title);
        }
        if (isNotEmpty(btnText)) {
            builder.positiveText(btnText);
        } else {
            builder.positiveText(R.string.f_library_dialog_material_ok);
        }
        return builder.content(content)
                .onPositive(btnCb)
                .cancelable(false)
                .build();
    }

    /**
     * 获取警告框
     *
     * @param context 上下文，没有传入时从SskSdk中读取当前的上下文
     * @param content 警告内容
     * @param btnCb   点击确认按钮回调
     * @return 对话框对象
     */
    public static MaterialDialog alert(@NonNull Context context, @NonNull String content, MaterialDialog.SingleButtonCallback btnCb) {
        return alert(context, null, content, null, btnCb);
    }

    /**
     * 显示警告框
     *
     * @param context 上下文，没有传入时从SskSdk中读取当前的上下文
     * @param title   标题，为空时不显示标题
     * @param content 警告内容
     * @param btnText 按钮文字，默认为“确认”
     * @param btnCb   点击确认按钮回调
     * @return 对话框对象
     */
    public static MaterialDialog showAlert(@NonNull Context context, String title, @NonNull String content, String btnText, MaterialDialog.SingleButtonCallback btnCb) {
        MaterialDialog dialog = alert(context, title, content, btnText, btnCb);
        dialog.show();
        return dialog;
    }

    /**
     * 显示警告框
     *
     * @param context 上下文，没有传入时从SskSdk中读取当前的上下文
     * @param content 警告内容
     * @param btnCb   点击确认按钮回调
     * @return 对话框对象
     */
    public static MaterialDialog showAlert(@NonNull Context context, @NonNull String content, MaterialDialog.SingleButtonCallback btnCb) {
        return showAlert(context, null, content, null, btnCb);
    }

    /**
     * 获取确认信息框
     *
     * @param context         上下文，没有传入时从SskSdk中读取当前的上下文
     * @param title           标题，为空时不显示标题
     * @param content         警告内容
     * @param positiveBtnText 确认按钮文字，默认为“确认”
     * @param negativeBtnText 取消按钮文字，默认为“取消”
     * @param positiveCb      点击确认按钮回调
     * @param negativeCb      点击取消按钮回调
     */
    public static MaterialDialog confirm(@NonNull Context context, String title, @NonNull String content, String positiveBtnText, String negativeBtnText, MaterialDialog.SingleButtonCallback positiveCb, MaterialDialog.SingleButtonCallback negativeCb) {
        MaterialDialog.Builder builder = new MaterialDialog.Builder(context);
        if (isNotEmpty(title)) {
            builder.title(title);
        }
        if (isNotEmpty(positiveBtnText)) {
            builder.positiveText(positiveBtnText);
        } else {
            builder.positiveText(R.string.f_library_dialog_material_ok);
        }
        if (isNotEmpty(negativeBtnText)) {
            builder.negativeText(negativeBtnText);
        } else {
            builder.negativeText(R.string.f_library_dialog_material_cancel);
        }
        return builder.content(content)
                .onPositive(positiveCb)
                .onNegative(negativeCb)
                .cancelable(false)
                .build();
    }

    /**
     * 获取确认信息框
     *
     * @param context    上下文，没有传入时从SskSdk中读取当前的上下文
     * @param content    警告内容
     * @param positiveCb 点击确认按钮回调
     * @param negativeCb 点击取消按钮回调
     */
    public static MaterialDialog confirm(@NonNull Context context, @NonNull String content, MaterialDialog.SingleButtonCallback positiveCb, MaterialDialog.SingleButtonCallback negativeCb) {
        return confirm(context, null, content, null, null, positiveCb, negativeCb);
    }

    /**
     * 显示确认信息框
     *
     * @param context         上下文，没有传入时从SskSdk中读取当前的上下文
     * @param title           标题，为空时不显示标题
     * @param content         警告内容
     * @param positiveBtnText 确认按钮文字，默认为“确认”
     * @param negativeBtnText 取消按钮文字，默认为“取消”
     * @param positiveCb      点击确认按钮回调
     * @param negativeCb      点击取消按钮回调
     */
    public static MaterialDialog showConfirm(@NonNull Context context, String title, @NonNull String content, String positiveBtnText, String negativeBtnText, MaterialDialog.SingleButtonCallback positiveCb, MaterialDialog.SingleButtonCallback negativeCb) {
        MaterialDialog dialog = confirm(context, title, content, positiveBtnText, negativeBtnText, positiveCb, negativeCb);
        dialog.show();
        return dialog;
    }

    /**
     * 显示确认信息框
     *
     * @param context    上下文，没有传入时从SskSdk中读取当前的上下文
     * @param content    警告内容
     * @param positiveCb 点击确认按钮回调
     * @param negativeCb 点击取消按钮回调
     */
    public static MaterialDialog showConfirm(@NonNull Context context, @NonNull String content, MaterialDialog.SingleButtonCallback positiveCb, MaterialDialog.SingleButtonCallback negativeCb) {
        return showConfirm(context, null, content, null, null, positiveCb, negativeCb);
    }

    /**
     * 获取提示输入对话框
     *
     * @param context   上下文
     * @param title     标题，为空时不显示标题
     * @param content   警告内容
     * @param inputHint 输入框提示内容
     * @param btnText   按钮文字，默认为“确认”
     * @param btnCb     点击确认按钮回调
     */
    public static MaterialDialog prompt(@NonNull Context context, String title, @NonNull String content, String inputHint, String btnText,
                                        MaterialDialog.SingleButtonCallback btnCb) {
        MaterialDialog.Builder builder = new MaterialDialog.Builder(context);
        if (isNotEmpty(title)) {
            builder.title(title);
        }
        if (isNotEmpty(btnText)) {
            builder.positiveText(btnText);
        } else {
            builder.positiveText(R.string.f_library_dialog_material_ok);
        }
        if (isNotEmpty(inputHint)) {
            builder.input(inputHint, "", new MaterialDialog.InputCallback() {
                @Override
                public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {

                }
            });
        }
        return builder.content(content)
                .alwaysCallInputCallback()
                .onPositive(btnCb)
                .cancelable(false)
                .build();
    }

    /**
     * 获取提示输入对话框
     *
     * @param context 上下文
     * @param content 警告内容
     * @param btnCb   点击确认按钮回调
     */
    public static MaterialDialog prompt(@NonNull Context context, @NonNull String content,
                                        MaterialDialog.SingleButtonCallback btnCb) {
        return prompt(context, null, content, null, null, btnCb);
    }

    /**
     * 显示提示输入对话框
     *
     * @param context   上下文
     * @param title     标题，为空时不显示标题
     * @param content   警告内容
     * @param inputHint 输入框提示内容
     * @param btnText   按钮文字，默认为“确认”
     * @param btnCb     点击确认按钮回调
     */
    public static MaterialDialog showPrompt(@NonNull Context context, String title, @NonNull String content, String inputHint, String btnText,
                                            MaterialDialog.SingleButtonCallback btnCb) {
        MaterialDialog dialog = prompt(context, title, content, inputHint, btnText, btnCb);
        dialog.show();
        return dialog;
    }

    /**
     * 显示提示输入对话框
     *
     * @param context 上下文
     * @param content 警告内容
     * @param btnCb   点击确认按钮回调
     */
    public static MaterialDialog showPrompt(@NonNull Context context, @NonNull String content,
                                            MaterialDialog.SingleButtonCallback btnCb) {
        return showPrompt(context, null, content, null, null, btnCb);
    }

    /**
     * 获取等待加载框
     *
     * @param context 上下文
     * @param content 提示内容，为空时不显示
     * @return 对话框对象
     */
    public static MaterialDialog loading(@NonNull Context context, String content) {
        MaterialDialog.Builder builder = new MaterialDialog.Builder(context);
        if (isNotEmpty(content)) {
            builder.content(content);
        }
        return builder.progress(true, 0)
                .progressIndeterminateStyle(false)
                .cancelable(false)
                .build();
    }

    /**
     * 获取等待加载框
     *
     * @param context 上下文
     * @param content 提示内容，为空时不显示
     * @return 对话框对象
     */
    public static MaterialDialog loadingHorizontal(@NonNull Context context, String content) {
        MaterialDialog.Builder builder = new MaterialDialog.Builder(context);
        if (isNotEmpty(content)) {
            builder.content(content);
        }
        return builder.progress(true, 0)
                .progressIndeterminateStyle(true)
                .cancelable(false)
                .build();
    }

    /**
     * 显示等待加载框
     *
     * @param context 上下文
     * @param content 提示内容，为空时不显示
     * @return 对话框对象
     */
    public static MaterialDialog showLoading(@NonNull Context context, String content) {
        MaterialDialog dialog = loading(context, content);
        dialog.show();
        return dialog;
    }

    /**
     * 显示等待加载框
     *
     * @param context 上下文
     * @param content 提示内容，为空时不显示
     * @return 对话框对象
     */
    public static MaterialDialog showLoadingHorizontal(@NonNull Context context, String content) {
        MaterialDialog dialog = loadingHorizontal(context, content);
        dialog.show();
        return dialog;
    }

    /**
     * 关闭对话框
     *
     * @param dialog 对话框对象
     */
    public static void dismiss(MaterialDialog dialog) {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    /**
     * 字符串是否不为空
     *
     * @param str 字符串
     * @return 是否不为空
     */
    private static boolean isNotEmpty(String str) {
        return str != null && str.trim().length() > 0;
    }
}
