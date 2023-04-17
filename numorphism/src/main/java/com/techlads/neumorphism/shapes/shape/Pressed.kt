package com.techlads.neumorphism.shapes.shape

import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import com.techlads.neumorphism.shapes.BlurMaker

open class Pressed(private val corderType: CornerType = CornerType.Rounded()): Shape {
    override fun drawShadows(
        drawScope: ContentDrawScope,
        blurMaker: BlurMaker,
        shapeConfig: ShapeConfig
    ) {
        TODO("Not yet implemented")
    }
}