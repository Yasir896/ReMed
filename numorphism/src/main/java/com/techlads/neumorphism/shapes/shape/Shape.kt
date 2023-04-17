package com.techlads.neumorphism.shapes.shape

import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import com.techlads.neumorphism.shapes.BlurMaker

interface Shape {
    fun drawShadows(drawScope: ContentDrawScope, blurMaker: BlurMaker, shapeConfig: ShapeConfig)
}