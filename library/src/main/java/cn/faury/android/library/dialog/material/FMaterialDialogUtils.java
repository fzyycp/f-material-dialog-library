package cn.faury.android.library.dialog.material;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.DatePicker;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import java.util.Calendar;
import java.util.Collection;

/**
 * 常用对话框工具：
 * 封装常用的alert、confirm、prompt、loading对话框
 */

public class FMaterialDialogUtils {

    /**
     * 获取警告框,不显示
     *
     * @param context 上下文，没有传入时从SskSdk中读取当前的上下文
     * @param title   标题，为空时不显示标题
     * @param content 警告内容
     * @param btnText 按钮文字，默认为“确认”
     * @param btnCb   点击确认按钮回调
     * @return 对话框对象
     */
    public static MaterialDialog alertDialog(@NonNull Context context
            , @Nullable String title
            , @NonNull String content
            , @Nullable String btnText
            , @Nullable MaterialDialog.SingleButtonCallback btnCb) {
        MaterialDialog.Builder builder = new MaterialDialog.Builder(context);
        if (isNotEmpty(title)) {
            builder.title(title);
        }
        if (isNotEmpty(btnText)) {
            builder.positiveText(btnText);
        } else {
            builder.positiveText(R.string.f_library_dialog_material_ok);
        }
        if (btnCb != null) {
            builder.onPositive(btnCb);
        }
        return builder.content(content)
                .cancelable(false)
                .build();
    }

    /**
     * 获取警告框,不显示
     *
     * @param context 上下文，没有传入时从SskSdk中读取当前的上下文
     * @param content 警告内容
     * @param btnCb   点击确认按钮回调
     * @return 对话框对象
     */
    public static MaterialDialog alertDialog(@NonNull Context context
            , @NonNull String content
            , @Nullable MaterialDialog.SingleButtonCallback btnCb) {
        return alertDialog(context, null, content, null, btnCb);
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
    public static MaterialDialog alert(@NonNull Context context
            , @Nullable String title
            , @NonNull String content
            , @Nullable String btnText
            , @Nullable MaterialDialog.SingleButtonCallback btnCb) {
        MaterialDialog dialog = alertDialog(context, title, content, btnText, btnCb);
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
    public static MaterialDialog alert(@NonNull Context context
            , @NonNull String content
            , @Nullable MaterialDialog.SingleButtonCallback btnCb) {
        return alert(context, null, content, null, btnCb);
    }

    /**
     * 获取确认信息框,不显示
     *
     * @param context         上下文，没有传入时从SskSdk中读取当前的上下文
     * @param title           标题，为空时不显示标题
     * @param content         警告内容
     * @param positiveBtnText 确认按钮文字，默认为“确认”
     * @param negativeBtnText 取消按钮文字，默认为“取消”
     * @param positiveCb      点击确认按钮回调
     * @param negativeCb      点击取消按钮回调
     */
    public static MaterialDialog confirmDialog(@NonNull Context context
            , @Nullable String title
            , @NonNull String content
            , @Nullable String positiveBtnText
            , @Nullable String negativeBtnText
            , @Nullable MaterialDialog.SingleButtonCallback positiveCb, MaterialDialog.SingleButtonCallback negativeCb) {
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
        if (positiveCb != null) {
            builder.onPositive(positiveCb);
        }
        if (negativeCb != null) {
            builder.onNegative(negativeCb);
        }
        return builder.content(content)
                .cancelable(false)
                .build();
    }

    /**
     * 获取确认信息框,不显示
     *
     * @param context    上下文，没有传入时从SskSdk中读取当前的上下文
     * @param content    警告内容
     * @param positiveCb 点击确认按钮回调
     * @param negativeCb 点击取消按钮回调
     */
    public static MaterialDialog confirmDialog(@NonNull Context context
            , @NonNull String content
            , @Nullable MaterialDialog.SingleButtonCallback positiveCb
            , @Nullable MaterialDialog.SingleButtonCallback negativeCb) {
        return confirmDialog(context, null, content, null, null, positiveCb, negativeCb);
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
    public static MaterialDialog confirm(@NonNull Context context
            , @Nullable String title
            , @NonNull String content
            , @Nullable String positiveBtnText
            , @Nullable String negativeBtnText
            , @Nullable MaterialDialog.SingleButtonCallback positiveCb
            , @Nullable MaterialDialog.SingleButtonCallback negativeCb) {
        MaterialDialog dialog = confirmDialog(context, title, content, positiveBtnText, negativeBtnText, positiveCb, negativeCb);
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
    public static MaterialDialog confirm(@NonNull Context context
            , @NonNull String content
            , @Nullable MaterialDialog.SingleButtonCallback positiveCb
            , @Nullable MaterialDialog.SingleButtonCallback negativeCb) {
        return confirm(context, null, content, null, null, positiveCb, negativeCb);
    }

    /**
     * 获取提示输入对话框,不显示
     *
     * @param context   上下文
     * @param title     标题，为空时不显示标题
     * @param content   警告内容
     * @param inputHint 输入框提示内容
     * @param btnText   按钮文字，默认为“确认”
     * @param minLength 最小长度
     * @param maxLength 最大长度
     * @param btnCb     点击确认按钮回调
     */
    public static MaterialDialog promptDialog(@NonNull Context context
            , @Nullable String title
            , @NonNull String content
            , @Nullable String inputHint
            , @Nullable String btnText
            , int minLength
            , int maxLength
            , @Nullable final MaterialDialog.InputCallback inputCb
            , @Nullable MaterialDialog.SingleButtonCallback btnCb) {
        MaterialDialog.Builder builder = new MaterialDialog.Builder(context);
        if (isNotEmpty(title)) {
            builder.title(title);
        }
        if (isNotEmpty(btnText)) {
            builder.positiveText(btnText);
        } else {
            builder.positiveText(R.string.f_library_dialog_material_ok);
        }
        builder.negativeText(R.string.f_library_dialog_material_cancel);
        if (isNotEmpty(inputHint)) {
            builder.input(inputHint, inputHint, new MaterialDialog.InputCallback() {
                @Override
                public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                    if (inputCb != null) {
                        inputCb.onInput(dialog, input);
                    }
                }
            });
        } else {
            builder.input("", "", new MaterialDialog.InputCallback() {
                @Override
                public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                    if (inputCb != null) {
                        inputCb.onInput(dialog, input);
                    }
                }
            });
        }
        if (minLength > -1 && maxLength > 0) {
            builder.inputRange(minLength, maxLength);
        }
        if (btnCb != null) {
            builder.onPositive(btnCb);
        }
        return builder.content(content)
                .alwaysCallInputCallback()
                .cancelable(false)
                .build();
    }

    /**
     * 获取提示输入对话框,不显示
     *
     * @param context   上下文
     * @param title     标题，为空时不显示标题
     * @param content   警告内容
     * @param inputHint 输入框提示内容
     * @param btnText   按钮文字，默认为“确认”
     * @param btnCb     点击确认按钮回调
     */
    public static MaterialDialog promptDialog(@NonNull Context context
            , @Nullable String title
            , @NonNull String content
            , @Nullable String inputHint
            , @Nullable String btnText
            , @Nullable MaterialDialog.SingleButtonCallback btnCb) {
        return promptDialog(context, title, content, inputHint, btnText, -1, -1, null, btnCb);
    }

    /**
     * 获取提示输入对话框,不显示
     *
     * @param context 上下文
     * @param content 警告内容
     * @param btnCb   点击确认按钮回调
     */
    public static MaterialDialog promptDialog(@NonNull Context context
            , @NonNull String content
            , @Nullable MaterialDialog.SingleButtonCallback btnCb) {
        return promptDialog(context, null, content, null, null, btnCb);
    }

    /**
     * 获取提示输入对话框,不显示
     *
     * @param context   上下文
     * @param title     标题，为空时不显示标题
     * @param content   警告内容
     * @param inputHint 输入框提示内容
     * @param btnText   按钮文字，默认为“确认”
     * @param minLength 最小长度
     * @param maxLength 最大长度
     * @param btnCb     点击确认按钮回调
     */
    public static MaterialDialog prompt(@NonNull Context context
            , @Nullable String title
            , @NonNull String content
            , @Nullable String inputHint
            , @Nullable String btnText
            , int minLength
            , int maxLength
            , @Nullable final MaterialDialog.InputCallback inputCb
            , @Nullable MaterialDialog.SingleButtonCallback btnCb) {
        MaterialDialog dialog = promptDialog(context, title, content, inputHint, btnText, minLength, maxLength, inputCb, btnCb);
        dialog.show();
        return dialog;
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
    public static MaterialDialog prompt(@NonNull Context context
            , @Nullable String title
            , @NonNull String content
            , @Nullable String inputHint
            , @Nullable String btnText
            , @Nullable MaterialDialog.SingleButtonCallback btnCb) {
        MaterialDialog dialog = promptDialog(context, title, content, inputHint, btnText, btnCb);
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
    public static MaterialDialog prompt(@NonNull Context context
            , @NonNull String content
            , @Nullable MaterialDialog.SingleButtonCallback btnCb) {
        return prompt(context, null, content, null, null, btnCb);
    }

    /**
     * 获取等待加载框,不显示
     *
     * @param context 上下文
     * @param content 提示内容，为空时不显示
     * @return 对话框对象
     */
    public static MaterialDialog loadingDialog(@NonNull Context context
            , @Nullable String content) {
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
     * 获取横向等待加载框,不显示
     *
     * @param context 上下文
     * @param content 提示内容，为空时不显示
     * @return 对话框对象
     */
    public static MaterialDialog loadingHorizontalDialog(@NonNull Context context
            , @Nullable String content) {
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
     * 显示等待加载框，转圈
     *
     * @param context 上下文
     * @param content 提示内容，为空时不显示
     * @return 对话框对象
     */
    public static MaterialDialog loading(@NonNull Context context
            , @Nullable String content) {
        MaterialDialog dialog = loadingDialog(context, content);
        dialog.show();
        return dialog;
    }

    /**
     * 显示等待加载框，横条显示
     *
     * @param context 上下文
     * @param content 提示内容，为空时不显示
     * @return 对话框对象
     */
    public static MaterialDialog loadingHorizontal(@NonNull Context context
            , @Nullable String content) {
        MaterialDialog dialog = loadingHorizontalDialog(context, content);
        dialog.show();
        return dialog;
    }

    /**
     * 选择对话框(单选)
     *
     * @param context         上下文
     * @param title           标题
     * @param items           备选项
     * @param selectedIdx     默认选中项
     * @param disabledIndices 禁用选项
     * @param singleChoiceCb  单选回调
     * @return 对话框对象
     */
    public static MaterialDialog choiceDialog(@NonNull Context context, @Nullable String title
            , @NonNull Collection<? extends CharSequence> items
            , int selectedIdx
            , @Nullable Integer[] disabledIndices
            , @Nullable final MaterialDialog.ListCallbackSingleChoice singleChoiceCb) {
        MaterialDialog.Builder builder = new MaterialDialog.Builder(context);
        if (isNotEmpty(title)) {
            builder.title(title);
        }
        builder.items(items)
                .itemsCallbackSingleChoice(selectedIdx, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View itemView, int which, CharSequence text) {
                        return singleChoiceCb != null && singleChoiceCb.onSelection(dialog, itemView, which, text);
                    }
                })
                .itemsDisabledIndices(disabledIndices)
                .positiveText(R.string.f_library_dialog_material_select)
                .negativeText(R.string.f_library_dialog_material_cancel);
        return builder.build();
    }

    /**
     * 选择对话框(多选)
     *
     * @param context         上下文
     * @param title           标题
     * @param items           备选项
     * @param selectedIndices 默认选中项
     * @param disabledIndices 禁用选项
     * @param multiChoiceCb   单选回调
     * @return 对话框对象
     */
    public static MaterialDialog choiceDialog(@NonNull Context context
            , @Nullable String title
            , @NonNull Collection<? extends CharSequence> items
            , @Nullable Integer[] selectedIndices
            , @Nullable Integer[] disabledIndices
            , @Nullable final MaterialDialog.ListCallbackMultiChoice multiChoiceCb) {
        MaterialDialog.Builder builder = new MaterialDialog.Builder(context);
        if (isNotEmpty(title)) {
            builder.title(title);
        }
        builder.items(items)
                .itemsCallbackMultiChoice(selectedIndices, new MaterialDialog.ListCallbackMultiChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, Integer[] which, CharSequence[] text) {
                        return multiChoiceCb != null && multiChoiceCb.onSelection(dialog, which, text);
                    }
                })
                .itemsDisabledIndices(disabledIndices)
                .positiveText(R.string.f_library_dialog_material_select)
                .negativeText(R.string.f_library_dialog_material_cancel);
        return builder.build();
    }

    /**
     * 显示选择对话框(单选)
     *
     * @param context         上下文
     * @param title           标题
     * @param items           备选项
     * @param selectedIdx     默认选中项
     * @param disabledIndices 禁用选项
     * @param singleChoiceCb  单选回调
     * @return 对话框对象
     */
    public static MaterialDialog choice(@NonNull Context context
            , @Nullable String title
            , @NonNull Collection<? extends CharSequence> items
            , int selectedIdx
            , @Nullable Integer[] disabledIndices
            , @Nullable final MaterialDialog.ListCallbackSingleChoice singleChoiceCb) {
        MaterialDialog dialog = choiceDialog(context, title, items, selectedIdx, disabledIndices, singleChoiceCb);
        dialog.show();
        return dialog;
    }

    /**
     * 显示选择对话框(多选)
     *
     * @param context         上下文
     * @param title           标题
     * @param items           备选项
     * @param selectedIndices 默认选中项
     * @param disabledIndices 禁用选项
     * @param multiChoiceCb   多选回调
     * @return 对话框对象
     */
    public static MaterialDialog choice(@NonNull Context context, String title
            , @NonNull Collection<? extends CharSequence> items
            , @Nullable Integer[] selectedIndices
            , @Nullable Integer[] disabledIndices
            , @Nullable final MaterialDialog.ListCallbackMultiChoice multiChoiceCb) {
        MaterialDialog dialog = choiceDialog(context, title, items, selectedIndices, disabledIndices, multiChoiceCb);
        dialog.show();
        return dialog;
    }

    /**
     * 日历选择器
     *
     * @param context           上下文
     * @param dftDate           默认日期
     * @param onDateSetListener 日历选择回调
     * @return 对话框对象
     */
    public static MaterialDialog datePickerDialog(@NonNull Context context
            , @Nullable Calendar dftDate
            , @Nullable final DatePickerDialog.OnDateSetListener onDateSetListener) {
        final MaterialDialog.Builder builder = new MaterialDialog.Builder(context);
        builder.customView(R.layout.f_library_dialog_material_datepicker, false)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        if (onDateSetListener != null && dialog.getCustomView() != null) {
                            DatePicker datePicker = dialog.getCustomView().findViewById(R.id.f_library_dialog_material_dp);
                            onDateSetListener.onDateSet(datePicker, datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
                        }
                    }
                })
                .positiveText(R.string.f_library_dialog_material_select)
                .negativeText(R.string.f_library_dialog_material_cancel);
        MaterialDialog dialog = builder.build();
        if (dftDate != null && dialog.getCustomView() != null) {
            DatePicker datePicker = dialog.getCustomView().findViewById(R.id.f_library_dialog_material_dp);
            datePicker.updateDate(dftDate.get(Calendar.YEAR), dftDate.get(Calendar.MONTH), dftDate.get(Calendar.DAY_OF_MONTH));
        }
        return dialog;
    }

    /**
     * 日历选择器
     *
     * @param context           上下文
     * @param dftDate           默认日期
     * @param onDateSetListener 日历选择回调
     * @return 对话框对象
     */
    public static MaterialDialog datePicker(@NonNull Context context
            , @Nullable Calendar dftDate
            , @Nullable final DatePickerDialog.OnDateSetListener onDateSetListener) {
        MaterialDialog dialog = datePickerDialog(context, dftDate, onDateSetListener);
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
