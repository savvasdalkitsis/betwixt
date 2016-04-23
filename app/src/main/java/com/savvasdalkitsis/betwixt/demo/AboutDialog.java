/*
 * Copyright (C) 2016 Savvas Dalkitsis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.savvasdalkitsis.betwixt.demo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class AboutDialog extends AppCompatDialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        TextView msg = new TextView(getActivity());
        msg.setText(Html.fromHtml(Utils.fromRaw(R.raw.about, getResources())));
        msg.setMovementMethod(LinkMovementMethod.getInstance());
        int padding = getResources().getDimensionPixelSize(R.dimen.about_padding);
        msg.setPadding(padding, padding, padding, 0);
        return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.about)
                .setView(msg)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dismiss();
                    }
                }).create();
    }

}
