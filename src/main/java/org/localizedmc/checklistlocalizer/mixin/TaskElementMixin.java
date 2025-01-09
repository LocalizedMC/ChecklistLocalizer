package org.localizedmc.checklistlocalizer.mixin;

import com.lclc98.checklist.client.gui.element.TaskElement;
import net.minecraft.text.Text;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Mixin(TaskElement.class)
public class TaskElementMixin {
    @Mutable
    @Shadow(remap = false) @Final protected String text;

    @Redirect(method = "<init>", at = @At(value = "FIELD", target = "Lcom/lclc98/checklist/client/gui/element/TaskElement;text:Ljava/lang/String;", opcode = Opcodes.PUTFIELD), remap = false)
    private void injected(TaskElement instance, String value) {
        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        Matcher matcher = pattern.matcher(value);

        if (text.isEmpty() | value.contains("===")) {
            this.text = value;
        } else if (matcher.find()) {
            this.text = Text.translatable(getLinkText(value, matcher)).getString();
        } else {
            this.text = Text.translatable(value).getString();
        }
    }

    @Unique
    private String getLinkText(String text, Matcher matcher) {
        if (matcher.find()) {
            // group(0) 是整个匹配的字符串，group(1) 是第一个括号内的内容
            String content = matcher.group(1);
            System.out.println("Extracted content:" + content);
            return content;
        } else {
            System.out.println("No match found.");
        }
        return text;
    }
}
