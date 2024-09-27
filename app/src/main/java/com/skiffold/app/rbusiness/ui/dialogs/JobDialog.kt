package com.skiffold.app.rbusiness.ui.dialogs

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import com.skiffold.app.rbusiness.databinding.DialogJobBinding

class JobDialog(private val context: Context) {

    private lateinit var dialog: AlertDialog
    fun showDialog(title: String, message: String, positiveButtonText: String, onPositiveClick: () -> Unit) {
        val binding = DialogJobBinding.inflate(LayoutInflater.from(context))

        binding.txtTitleDialog.text = title
        binding.txtDescDialog.text = message
        binding.btnDialog.text = positiveButtonText

        dialog = AlertDialog.Builder(context)
            .setView(binding.root)
            .setCancelable(false)
            .create()

        binding.btnDialog.setOnClickListener {
            onPositiveClick()
            dialog.dismiss()
        }

        dialog.show()
    }
}