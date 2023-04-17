package com.techlads.neumorphism.shapes.shape

import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.techlads.neumorphism.shapes.BlurMaker

open class Punched(private val corderType: CornerType = CornerType.Rounded()): Shape {
    override fun drawShadows(
        drawScope: ContentDrawScope,
        blurMaker: BlurMaker,
        shapeConfig: ShapeConfig
    ) {
        TODO("Not yet implemented")
    }

    class Oval(): Punched(CornerType.Oval)

    class Rounded(radius: Dp = 12.dp) : Punched(CornerType.Rounded(radius))
}