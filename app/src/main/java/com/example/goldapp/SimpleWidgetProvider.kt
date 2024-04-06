package com.example.goldapp

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import java.util.Random


class SimpleWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        val count = appWidgetIds.size
        for (i in 0 until count) {
            val widgetId = appWidgetIds[i]
            val number = String.format("%03d", Random().nextInt(900) + 100)
            val remoteViews = RemoteViews(
                context.packageName,
                R.layout.simple_widget
            )
            remoteViews.setTextViewText(R.id.textView, number)
            val intent = Intent(context, SimpleWidgetProvider::class.java)
            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE)
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds)
            val pendingIntent = PendingIntent.getBroadcast(
                context,
                0, intent, PendingIntent.FLAG_UPDATE_CURRENT
            )
            remoteViews.setOnClickPendingIntent(R.id.actionButton, pendingIntent)
            appWidgetManager.updateAppWidget(widgetId, remoteViews)
        }
    }
}