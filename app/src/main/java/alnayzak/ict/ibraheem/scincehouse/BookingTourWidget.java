package alnayzak.ict.ibraheem.scincehouse;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class BookingTourWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        Intent tour = new Intent(context , Tour.class);
        PendingIntent pendingtourIntent = PendingIntent.getActivity(context,0,tour,0);

        Intent gift = new Intent(context, Gifts.class);
        PendingIntent pendingGiftIntent = PendingIntent.getActivity(context,0,gift,0);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.booking_tour_widget);
        views.setOnClickPendingIntent(R.id.booking_wid , pendingtourIntent);
        views.setOnClickPendingIntent(R.id.gift_wid , pendingGiftIntent);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

