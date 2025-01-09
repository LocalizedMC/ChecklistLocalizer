package org.localizedmc.checklistlocalizer.mixin;

import com.lclc98.checklist.client.gui.element.TaskElement;
import net.minecraft.text.Text;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@OnlyIn(Dist.CLIENT)
@Mixin(TaskElement.class)
public class TaskElementMixin {
    @Mutable
    @Shadow(remap = false) @Final protected String text;

    @Redirect(method = "<init>", at = @At(value = "FIELD", target = "Lcom/lclc98/checklist/client/gui/element/TaskElement;text:Ljava/lang/String;", opcode = Opcodes.PUTFIELD), remap = false)
    private void injected(TaskElement instance, String value) {
        this.text = Text.translatable(value).getString();
    }
}
