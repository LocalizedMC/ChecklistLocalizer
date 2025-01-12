package org.localizedmc.checklistlocalizer.mixin;

import com.lclc98.checklist.client.gui.element.TaskElement;
import net.minecraft.text.Text;
import org.localizedmc.checklistlocalizer.ChecklistLocalizer;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TaskElement.class)
public class TaskElementMixin {
    @Mutable
    @Shadow(remap = false) @Final protected String text;

    @Redirect(method = "<init>", at = @At(value = "FIELD", target = "Lcom/lclc98/checklist/client/gui/element/TaskElement;text:Ljava/lang/String;", opcode = Opcodes.PUTFIELD), remap = false)
    private void injected(TaskElement instance, String value) {
        if (value != null) {
            this.text = Text.translatable(value).getString();
            ChecklistLocalizer.LOGGER.info("Localizer is working!");
        }
    }
}
