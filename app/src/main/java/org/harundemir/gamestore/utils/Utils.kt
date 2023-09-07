package org.harundemir.gamestore.utils

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.pdf.PdfDocument
import android.os.Build
import android.os.Environment
import android.widget.Toast
import org.harundemir.gamestore.R
import org.harundemir.gamestore.models.Order
import org.harundemir.gamestore.models.OrderItem
import java.io.File
import java.io.FileOutputStream
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale
import kotlin.random.Random


object Utils {
    val taxRate = 0.2
    fun generateOrderCode(): String {
        val alphanumericChars = ('A'..'Z') + ('0'..'9')
        return (1..8)
            .map { alphanumericChars[Random.nextInt(alphanumericChars.size)] }
            .joinToString("")
    }

    fun getFormattedDateTime(dateTimeString: String): String {
        return try {
            val instant = Instant.parse(dateTimeString)
            val zoneId = ZoneId.systemDefault()
            val zonedDateTime = instant.atZone(zoneId)
            val currentLocale = Locale.getDefault()
            val formatter = DateTimeFormatter.ofPattern("EEE, MMM dd yyyy", currentLocale)
            zonedDateTime.format(formatter)
        } catch (e: Exception) {
            e.printStackTrace()
            "Error occurred"
        }
    }

    fun getLocalizedDate(): String {
        val calendar = Calendar.getInstance()
        val locale = Locale.getDefault() // Get the user's device locale
        val dateFormat = SimpleDateFormat("dd MMMM yyyy", locale) // Define your desired date format

        return dateFormat.format(calendar.time)
    }

    fun roundToTwoDecimalPlaces(value: Double): Double {
        val bigDecimalValue = BigDecimal(value)
        val roundedValue = bigDecimalValue.setScale(2, RoundingMode.HALF_UP)
        return roundedValue.toDouble()
    }

    fun createPDF(context: Context, order: Order, orderItems: List<OrderItem>) {
        val locale = Locale.getDefault()
        val pdfDocument = PdfDocument()
        val pageWidth = 595
        val pageHeight = 842
        val rectBottom = 340f
        val verticalSpacing = 30f
        var lastVerticalPosition = 0f
        val pageInfo = PdfDocument.PageInfo.Builder(pageWidth, pageHeight, 1).create()
        val page = pdfDocument.startPage(pageInfo)
        val canvas = page.canvas

        val defaultAlignedLeft = Paint().apply {
            textAlign = Paint.Align.LEFT
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
            textSize = 12f
        }

        val defaultAlignedRight = Paint().apply {
            textAlign = Paint.Align.RIGHT
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
            textSize = 12f
        }

        val boldAlignedLeft = Paint().apply {
            textAlign = Paint.Align.LEFT
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            textSize = 12f
        }

        val paint = Paint()

        val companyNamePaint = Paint(boldAlignedLeft)
        val invoicePaint = Paint()

        val companyAddressLine1Paint = Paint(defaultAlignedLeft)
        val companyAddressLine2Paint = Paint(defaultAlignedLeft)
        val companyPhonePaint = Paint(defaultAlignedLeft)
        val companyFaxPaint = Paint(defaultAlignedLeft)
        val invoiceNoPaint = Paint(defaultAlignedRight)
        val invoiceDatePaint = Paint(defaultAlignedRight)

        val customerInfoTitlePaint = Paint(boldAlignedLeft)
        val customerNamePaint = Paint(defaultAlignedLeft)
        val customerAddressLine1Paint = Paint(defaultAlignedLeft)
        val customerAddressLine2Paint = Paint(defaultAlignedLeft)
        val customerPhonePaint = Paint(defaultAlignedLeft)

        val tablePaint = Paint().apply {
            style = Paint.Style.STROKE
            strokeWidth = 2f
        }

        invoicePaint.apply {
            textAlign = Paint.Align.RIGHT
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            textSize = 20f
            color = Color.parseColor("#595959")
        }

        canvas.apply {
            drawText(
                context.getString(R.string.app_name),
                40f, 60f, companyNamePaint
            )
            drawText(
                context.getString(R.string.invoice).uppercase(),
                (pageWidth - 40).toFloat(),
                60f + (companyNamePaint.textSize / 4),
                invoicePaint
            )

            drawText(
                "1234 Elm Street, East", 40f, 120f, companyAddressLine1Paint
            )
            drawText(
                "Anytown, USA 12345", 40f, 140f, companyAddressLine2Paint
            )
            drawText(
                context.getString(R.string.phone_value, "555-123-4567"), 40f, 160f, companyPhonePaint
            )
            drawText(
                context.getString(R.string.fax_value, "555-123-4568"), 40f, 180f, companyFaxPaint
            )
            drawText(
                context.getString(R.string.invoice_no_with_value, order.code),
                (pageWidth - 40).toFloat(),
                160f,
                invoiceNoPaint
            )
            drawText(
                context.getString(R.string.invoice_date_with_value, getLocalizedDate()),
                (pageWidth - 40).toFloat(),
                180f,
                invoiceDatePaint
            )

            drawText(
                context.getString(R.string.billed_to).uppercase(locale),
                40f, 210f, customerInfoTitlePaint
            )
            drawText(
                "John Doe", 40f, 230f, customerNamePaint
            )
            drawText(
                "12346 Mel Underpass, West", 40f, 250f, customerAddressLine1Paint
            )
            drawText(
                "Anytown, USA 12347", 40f, 270f, customerAddressLine2Paint
            )
            drawText(
                "555-124-4548", 40f, 290f, customerPhonePaint
            )

            drawRect(40f, 310f, (pageWidth - 40).toFloat(), rectBottom, tablePaint)

            paint.apply {
                textAlign = Paint.Align.LEFT
                typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
                style = Paint.Style.FILL
            }
            drawText(context.getString(R.string.qty).uppercase(locale), 50f, 329f, paint)
            drawText(context.getString(R.string.item).uppercase(locale), 110f, 329f, paint)
            drawText(context.getString(R.string.price).uppercase(locale), 390f, 329f, paint)
            drawText(
                context.getString(R.string.amount).uppercase(locale),
                (pageWidth - 115).toFloat(),
                329f,
                paint
            )

            drawLine(100f, 310f, 100f, 340f, paint)
            drawLine(380f, 310f, 380f, 340f, paint)
            drawLine(470f, 310f, 470f, 340f, paint)

            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)

            for (i in orderItems.indices) {
                lastVerticalPosition = rectBottom + 30f + i * verticalSpacing
                drawText(
                    orderItems[i].item.quantity.toString(),
                    50f,
                    lastVerticalPosition,
                    paint
                )
                drawText(
                    orderItems[i].item.item.title,
                    110f,
                    lastVerticalPosition,
                    paint
                )
                drawText(
                    context.getString(R.string.total_with_value, orderItems[i].item.item.price.toString()),
                    390f,
                    lastVerticalPosition,
                    paint
                )
                drawText(
                    context.getString(R.string.total_with_value, orderItems[i].item.total.toString()),
                    (pageWidth - 115).toFloat(),
                    lastVerticalPosition,
                    paint
                )
            }

            drawLine(
                40f,
                lastVerticalPosition + 20f,
                (pageWidth - 40).toFloat(),
                lastVerticalPosition + 20f,
                paint
            )

            drawText(
                context.getString(R.string.subtotal).uppercase(locale),
                390f,
                lastVerticalPosition + 50f,
                paint
            )
            drawText(
                context.getString(R.string.tax).uppercase(locale),
                390f,
                lastVerticalPosition + 80f,
                paint
            )
            drawText(
                context.getString(R.string.total).uppercase(locale),
                390f,
                lastVerticalPosition + 110f,
                paint
            )

            drawText(
                context.getString(R.string.total_with_value, order.subtotal.toString()),
                (pageWidth - 115).toFloat(),
                lastVerticalPosition + 50f,
                paint
            )
            drawText(
                context.getString(R.string.total_with_value, order.tax.toString()),
                (pageWidth - 115).toFloat(),
                lastVerticalPosition + 80f,
                paint
            )
            drawText(
                context.getString(R.string.total_with_value, order.total.toString()),
                (pageWidth - 115).toFloat(),
                lastVerticalPosition + 110f,
                paint
            )

            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
            drawText(
                context.getString(R.string.tax_rate_description, (taxRate * 100).toString()),
                40f,
                lastVerticalPosition + 150f,
                paint
            )
        }

        pdfDocument.finishPage(page)

        val directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
        val file = File(
            directory,
            "${order.code}_invoice_${Locale.getDefault().language}.pdf"
        )
        try {
            pdfDocument.writeTo(FileOutputStream(file))
            Toast.makeText(context, context.getString(R.string.pdf_file_created), Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(context, context.getString(R.string.failed_to_create_pdf_file), Toast.LENGTH_SHORT)
                .show()
        }
        pdfDocument.close()
    }
}